package TreeDFS;

import javax.swing.tree.TreeNode;

public class LowestCommonAncestor {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        private TreeNode lca;

        public Solution() {
            this.lca = null;
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            lowestCommonAncestorRec(root, p, q);
            return lca;
        }

        private boolean lowestCommonAncestorRec(TreeNode currentNode, TreeNode p, TreeNode q) {
            if (currentNode == null)
                return false;

            boolean left = false, right = false, mid = false;
            if (p == currentNode || q == currentNode)
                mid = true;

            left = lowestCommonAncestorRec(currentNode.left, p, q);
            if (lca == null)
                right = lowestCommonAncestorRec(currentNode.right, p, q);

            if (boolToInt(mid) + boolToInt(left) + boolToInt(right) >= 2)
                lca = currentNode;

            return mid || left || right;
        }

        private int boolToInt(boolean val) {
            return (val) ? 1 : 0;
        }
    }
}
