package TreeDFS;

import java.util.HashMap;

import javax.swing.tree.TreeNode;

public class BinaryTreeConstruction {
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
        public TreeNode buildTreeHelper(int[] pOrder, int[] iOrder, int left, int right,
                HashMap<Integer, Integer> mapping, int[] pIndex) {
            if (left > right) {
                return null;
            }

            int curr = pOrder[pIndex[0]];
            pIndex[0]++;
            TreeNode root = new TreeNode(curr);

            if (left == right) {
                return root;
            }

            int inIndex = mapping.get(curr);
            root.left = buildTreeHelper(pOrder, iOrder, left, inIndex - 1, mapping, pIndex);
            root.right = buildTreeHelper(pOrder, iOrder, inIndex + 1, right, mapping, pIndex);

            return root;

        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            HashMap<Integer, Integer> mapping = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                mapping.put(inorder[i], i);
            }

            int[] pIndex = { 0 };
            return buildTreeHelper(preorder, inorder, 0, preorder.length - 1, mapping, pIndex);

        }
    }
}
