package TreeDFS;

import javax.swing.tree.TreeNode;

public class ValidateBST {
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

        private boolean validateBstHelper(TreeNode root, long[] prev) {
            if (root == null)
                return true;

            if (!validateBstHelper(root.left, prev))
                return false;

            if (root.val <= prev[0])
                return false;

            prev[0] = root.val;

            return validateBstHelper(root.right, prev);
        }

        public boolean isValidBST(TreeNode root) {
            long[] prev = { Long.MIN_VALUE };
            return validateBstHelper(root, prev);
        }
    }
}
