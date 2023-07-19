package Trees;

import javax.swing.tree.TreeNode;

public class IsTreeSubtree {
    class Solution {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            String tree1 = preorder(root);
            String tree2 = preorder(subRoot);
            return tree1.indexOf(tree2) >= 0;
        }

        private String preorder(TreeNode t) {
            if (t == null)
                return "null";
            return "#" + t.val + " " + preorder(t.left) + " " + preorder(t.right);
        }
    }
}
