package Graph;


// Definition of TreeNode:
class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class MaximumDepthOfBinaryTreeRecursive {
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
    public static int maxDepth(TreeNode root){
        if (root == null) return 0;

        int leftMaximum = maxDepth(root.left);
        int rightMaximum = maxDepth(root.right);

        return Math.max(leftMaximum, rightMaximum) + 1;
    }
}
