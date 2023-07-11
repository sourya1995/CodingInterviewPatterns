package TreeBFS;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode sibling;

    TreeNode(int val) {
        this.val = val;
    }
}

class ConnectSiblings {
    public void connectSiblings(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode prevNode = null;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                if (prevNode != null) {
                    prevNode.sibling = currentNode;
                }

                prevNode = currentNode;

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
    }
}

