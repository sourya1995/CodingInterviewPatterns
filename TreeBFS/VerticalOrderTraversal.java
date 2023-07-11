package TreeBFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.tree.TreeNode;

public class VerticalOrderTraversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        private Map<Integer, List<int[]>> verticalMap;

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            verticalMap = new TreeMap<>();
            dfs(root, 0, 0);

            for (List<int[]> list : verticalMap.values()) {
                Collections.sort(list, (a, b) -> {
                    if (a[0] == b[0]) {
                        return a[1] - b[1];
                    } else {
                        return a[0] - b[0];
                    }
                });

                List<Integer> verticalList = new ArrayList<>();
                for (int[] entry : list) {
                    verticalList.add(entry[1]);
                }
                result.add(verticalList);
            }

            return result;
        }

        private void dfs(TreeNode node, int x, int y) {
            if (node == null) {
                return;
            }

            verticalMap.computeIfAbsent(x, k -> new ArrayList<>()).add(new int[] { y, node.val });
            dfs(node.left, x - 1, y + 1);
            dfs(node.right, x + 1, y + 1);
        }
    }
}
