package Graph;

import org.omg.CORBA.TRANSACTION_MODE;

public class MazeDFS {
    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start = {0, 4};
//		int[] destination = {4,4};
        int[] destination = {3, 2};

        MazeDFS dfs = new MazeDFS();
        System.out.println(dfs.hasPath(maze, start, destination));
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

        boolean[][] visited = new boolean[maze.length][maze[0].length];
        if (dfs(maze, visited, start, destination)) return true;

        return result;
    }

    boolean dfs(int[][] maze, boolean[][] visited, int[] start, int[] destination) {
        int x = start[0];
        int y = start[1];
        if (x<0 || x >= maze.length || y < 0 || y>=maze[0].length) return false;

        if (start[0] == destination[0] && start[1] == destination[1]) return true;

        if (visited[start[0]][start[1]] == true) return false;
        visited[start[0]][start[1]] = true;

        while (x>=0 && x<maze.length-1 && maze[x][y] != 1) {
            x++;
        }
        if (maze[x][y] == 1) x--;
        if(dfs(maze, visited, new int[]{x,y}, destination)) return true;

        x = start[0];
        y = start[1];

        while (y>=0 && y<maze[0].length-1 && maze[x][y] != 1) {
            y++;
        }
        if (maze[x][y] == 1) y--;
        if(dfs(maze, visited, new int[]{x,y}, destination)) return true;

        x = start[0];
        y = start[1];

        while (x>0 && x<maze.length && maze[x][y] != 1) {
            x--;
        }
        if (maze[x][y] == 1) x++;
        if(dfs(maze, visited, new int[]{x,y}, destination)) return true;

        x = start[0];
        y = start[1];

        while (y>0 && y<maze[0].length && maze[x][y] != 1) {
            y--;
        }
        if (maze[x][y] == 1) y++;
        if(dfs(maze, visited, new int[]{x,y}, destination)) return true;

        return false;
    }

}
