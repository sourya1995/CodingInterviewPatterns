package TreeDFS;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
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

    private static void dfs(TreeNode node, int level, List<Integer> rside) {
        if (level == rside.size()) {
            rside.add(node.val);
        }

        List<TreeNode> children = new ArrayList<TreeNode>();
        children.add(node.right);
        children.add(node.left);

        for (TreeNode child : children) {
            if (child != null) {
                dfs(child, level + 1, rside);
            }
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> rside = new ArrayList<Integer>();
        dfs(root, 0, rside);

        return rside;
    }
}
