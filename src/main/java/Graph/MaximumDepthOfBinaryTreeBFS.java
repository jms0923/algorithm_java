package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


// Definition of TreeNode:
//class TreeNode {
//    public int val;
//    public TreeNode left, right;
//    public TreeNode(int val) {
//        this.val = val;
//        this.left = this.right = null;
//    }
//}

public class MaximumDepthOfBinaryTreeBFS {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(maxDepth(root));
    }

    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public static int maxDepth(TreeNode root) {
        int level = 0;
        if (root == null) return level;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode now = queue.poll();
                if (now.left != null) queue.offer(now.left);
                if (now.right != null) queue.offer(now.right);
            }
            level++;
        }

        return level;
    }
}
