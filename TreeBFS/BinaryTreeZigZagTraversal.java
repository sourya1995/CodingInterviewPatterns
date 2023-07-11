package TreeBFS;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        Deque<TreeNode> dq = new LinkedList<TreeNode>();
        dq.add(root);
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        boolean reverse = false;
        while (!dq.isEmpty()) {
            int size = dq.size();
            results.add(new ArrayList<Integer>());
            for (int i = 0; i < size; i++) {
                if (!reverse) {
                    TreeNode node = dq.pollFirst();
                    results.get(results.size() - 1).add(node.val);
                    if (node.left != null)
                        dq.addLast(node.left);
                    if (node.right != null)
                        dq.addLast(node.right);
                } else {
                    TreeNode node = dq.pollLast();
                    results.get(results.size() - 1).add(node.val);
                    if (node.right != null)
                        dq.addFirst(node.right);
                    if (node.left != null)
                        dq.addFirst(node.left);
                }
            }
            reverse = !reverse;
        }

        return results;
    }
}
