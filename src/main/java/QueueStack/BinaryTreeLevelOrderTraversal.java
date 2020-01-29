package QueueStack;

import java.lang.reflect.Array;
import java.util.*;


// Definition of TreeNode:
class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
        root.right.right.right.right = new TreeNode(8);

        System.out.println(levelOrderBFS(root));
        System.out.println(levelOrderDFS(root));
    }

    // BFS with one queue
    public static List<List<Integer>> levelOrderBFS(TreeNode root) {
        /**
         * @param root: A Tree
         * @return: Level order a list of lists of integer
         */
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (; size > 0; size--) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            result.add(list);
        }

        return result;
    }

    // DFS
    public static List<List<Integer>> levelOrderDFS(TreeNode root) {
        /**
         * @param root: A Tree
         * @return: Level order a list of lists of integer
         */
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        int maxLevel = 0;
        while (true) {
            List<Integer> list = new ArrayList<>();
            dfs(root, list, 0, maxLevel);
            if (list.size() == 0) break;
            maxLevel += 1;
            result.add(list);
        }

        return result;
    }

    private static void dfs(TreeNode root, List<Integer> list, int curtLevel, int maxLevel) {
        /**
         * @param root : A tree
         * @param list : Integer list to save current level node's value
         * @param curtLevel : current node's level
         * @param maxLevel : level to save the node' value
         */
        if (root == null || curtLevel > maxLevel)
            return;

        if (curtLevel == maxLevel) {
            list.add(root.val);
            return;
        }
        dfs(root.left, list, curtLevel + 1, maxLevel);
        dfs(root.right, list, curtLevel + 1, maxLevel);
    }
}
