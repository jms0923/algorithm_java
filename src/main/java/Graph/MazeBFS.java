package Graph;

import java.util.*;
import java.util.stream.Collectors;

public class MazeBFS {
    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start = {0, 4};
		int[] dest = {4,4};
//        int[] dest = {3, 2};
        MazeBFS BFS = new MazeBFS();
        System.out.println(BFS.hasPath(maze, start, dest));
    }

    /**
     * @param maze:        the maze
     * @param start:       the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean result = false;
        if (maze == null || maze.length == 0) return result;
        if (Arrays.equals(start, destination)) return true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        HashSet<List<Integer>> dict = new HashSet<>();
        dict.add(Arrays.stream(start).boxed().collect(Collectors.toList()));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int[] tempNode = goToWall(maze, node, j);
                    if (!Arrays.equals(tempNode, destination)) {
                        if (!dict.contains(Arrays.stream(tempNode).boxed().collect(Collectors.toList()))) {
                            queue.add(tempNode);
                            dict.add(Arrays.stream(tempNode).boxed().collect(Collectors.toList()));
                        }
                    } else {
                        return true;
                    }
                }
            }
        }

        return result;
    }

    int[] goToWall(int[][] maze, int[] started, int direction) {
        int[] result = {};
        int maxYIndex = maze.length - 1;
        int maxXIndex = maze[0].length - 1;
        int[] start = started.clone();

        for (int i = 0; i < maxXIndex; i++) {
            for (int j = 0; j < maxYIndex; j++) {
                switch (direction) {
                    // up case
                    case 0:
                        if (maze[start[0]][start[1]] == 1) {
                            start[0]++;
                            return start;
                        } else if (start[0] <= 0) {
                            return start;
                        } else {
                            start[0]--;
                            break;
                        }
                        // right case
                    case 1:
                        if (maze[start[0]][start[1]] == 1) {
                            start[1]--;
                            return start;
                        } else if (start[1] >= maxXIndex) {
                            return start;
                        } else {
                            start[1]++;
                            break;
                        }
                        // down case
                    case 2:
                        if (maze[start[0]][start[1]] == 1) {
                            start[0]--;
                            return start;
                        } else if (start[0] >= maxYIndex) {
                            return start;
                        } else {
                            start[0]++;
                            break;
                        }
                        // left case
                    case 3:
                        if (maze[start[0]][start[1]] == 1) {
                            start[1]++;
                            return start;
                        } else if (start[1] <= 0) {
                            return start;
                        } else {
                            start[1]--;
                            break;
                        }
                }
            }
        }

        return result;
    }
}
