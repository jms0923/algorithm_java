package Graph;

import java.util.Stack;

public class MaximumDepthOfBinaryTreeDFS {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(maxDepth(root));
    }


    public static int maxDepth(TreeNode root) {
        int level = 0;
        if (root == null) return level;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value  = new Stack<>();
        stack.push(root);
        value.push(1);

        while (!stack.isEmpty()){
            TreeNode now = stack.pop();
            int nowLevel = value.pop();
            if (now.left != null) {
                stack.push(now.left);
                value.push(nowLevel+1);
            }
            if (now.right != null) {
                stack.push(now.right);
                value.push(nowLevel+1);
            }
            level = Math.max(level, nowLevel);
        }

        return level;
    }
}
