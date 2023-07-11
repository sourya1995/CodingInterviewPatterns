package TreeDFS;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class DiameterOfBinaryTree {
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
        public static List<Integer> diameterHelper(TreeNode node, int diameterResult) {
            List<Integer> result = new ArrayList<>();
            if (node == null) {
                result.add(0);
                result.add(diameterResult);
                return result;
            } else {
                List<Integer> leftHeight = diameterHelper(node.left, diameterResult);
                diameterResult = leftHeight.get(1);
                List<Integer> rightHeight = diameterHelper(node.right, diameterResult);
                diameterResult = rightHeight.get(1);
                diameterResult = Math.max(diameterResult, leftHeight.get(0) + rightHeight.get(0));
                result.add(Math.max(leftHeight.get(0), rightHeight.get(0)) + 1);
                result.add(diameterResult);
                return result;
            }
        }

        public int diameterOfBinaryTree(TreeNode root) {
            List<Integer> _diameterResult;
            int diameterResult = 0;
            if (root == null)
                return 0;
            _diameterResult = diameterHelper(root, diameterResult);
            return _diameterResult.get(1);

        }
    }
}
