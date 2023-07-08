package TopKElements;

import javax.swing.tree.TreeNode;

public class KthSmallestElementInBST {
    int count = 0;
    int smallest = 0;
    public int kthSmallest(TreeNode root, int k) {
        DFS(root, k);
        return smallest;
    }

    public void DFS(TreeNode root, int k){
        if(root == null) return;
        DFS(root.left, k);
        count++;
        if(count==k){
            smallest = root.val;
            return;
        }
        DFS(root.right, k);
    }
}
