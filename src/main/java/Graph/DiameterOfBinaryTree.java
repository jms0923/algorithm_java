package Graph;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 * public int val;
 * public TreeNode left, right;
 * public TreeNode(int val) {
 * this.val = val;
 * this.left = this.right = null;
 * }
 * }
 */

public class DiameterOfBinaryTree {
    static int max = 0;

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);

        System.out.println(diameterOfBinaryTree(root));
    }

    /**
     * @param root: a root of binary tree
     * @return: return a integer
     */
    public static int diameterOfBinaryTree(TreeNode root) {
        int max = 0;
        maxDepth(root);
        return max;
    }

    static int maxDepth(TreeNode root){
        System.out.println("max : " + max);
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        max = Math.max(max, left + right);

        return Math.max(left, right)+1;
    }
}
