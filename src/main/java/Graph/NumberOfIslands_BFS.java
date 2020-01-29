package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands_BFS {
    public static void main(String[] args) {
//        boolean[][] grid = {
//                {true, true, false, false, true},
//                {true, true, false, false, false},
//                {false, false, false, false, false},
//                {true, false, false, true, true}};

//        boolean[][] grid = {
//                {true, true, false, false, false},
//                {false, true, false, false, true},
//                {false, false, false, true, true},
//                {false, false, false, false, false},
//                {false, false, false, false, true}};

//        [[0,1,0,0,1,1,1,0,0,0,0,0,1,0,0,0,0,1,0,1],[1,0,1,0,0,1,1,0,0,1,0,1,0,1,0,1,1,0,0,0],[0,1,0,0,0,1,1,1,1,0,0,0,0,0,1,1,1,1,0,1],[1,1,0,0,0,1,1,0,0,0,1,1,1,0,0,1,0,1,1,0],[0,1,0,1,1,0,1,0,0,0,1,0,0,1,0,0,0,0,0,1],[1,0,0,1,0,1,0,0,0,1,1,0,1,0,0,1,0,0,0,0],[1,0,0,0,1,1,0,0,0,0,0,1,0,0,1,0,0,0,0,1],[1,0,0,0,1,0,1,1,1,0,1,0,1,1,1,1,0,0,0,1],[1,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,1],[0,0,0,1,0,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0],[1,0,1,0,1,0,0,1,1,1,0,1,1,0,0,1,1,0,0,0],[0,1,0,0,1,0,0,0,0,0,0,1,1,1,1,0,0,0,1,0],[1,0,0,0,1,1,1,0,1,0,0,0,1,0,1,0,1,0,0,1],[0,0,0,0,1,0,1,1,0,1,0,1,0,1,1,1,1,0,0,0],[0,1,1,0,0,0,0,1,0,0,1,1,1,0,0,1,1,0,1,0],[1,0,1,1,1,1,1,1,0,1,1,0,1,0,0,1,0,0,0,1],[1,0,0,0,1,0,1,0,0,1,0,1,0,0,1,0,0,1,1,1],[0,0,1,0,0,0,0,1,0,0,1,1,0,1,1,1,0,0,0,0],[0,0,1,0,0,0,0,0,0,1,1,0,1,0,1,0,0,0,1,1],[1,0,0,0,1,0,1,1,1,0,0,1,0,1,0,1,1,0,0,0]]
//        boolean[][] grid = {
//        {false,true,false,false,true,true,true,false,false,false,false,false,true,false,false,false,false,true,false,true},
//        {true,false,true,false,false,true,true,false,false,true,false,true,false,true,false,true,true,false,false,false},
//        {false,true,false,false,false,true,true,true,true,false,false,false,false,false,true,true,true,true,false,true},
//        {true,true,false,false,false,true,true,false,false,false,true,true,true,false,false,true,false,true,true,false},
//        {false,true,false,true,true,false,true,false,false,false,true,false,false,true,false,false,false,false,false,true},
//        {true,false,false,true,false,true,false,false,false,true,true,false,true,false,false,true,false,false,false,false},
//        {true,false,false,false,true,true,false,false,false,false,false,true,false,false,true,false,false,false,false,true},
//        {true,false,false,false,true,false,true,true,true,false,true,false,true,true,true,true,false,false,false,true},
//        {true,false,false,true,false,false,false,true,false,false,false,false,false,false,false,false,false,true,false,true},
//        {false,false,false,true,false,true,true,true,true,true,true,true,true,true,false,false,false,false,true,false},
//        {true,false,true,false,true,false,false,true,true,true,false,true,true,false,false,true,true,false,false,false},
//        {false,true,false,false,true,false,false,false,false,false,false,true,true,true,true,false,false,false,true,false},
//        {true,false,false,false,true,true,true,false,true,false,false,false,true,false,true,false,true,false,false,true},
//        {false,false,false,false,true,false,true,true,false,true,false,true,false,true,true,true,true,false,false,false},
//        {false,true,true,false,false,false,false,true,false,false,true,true,true,false,false,true,true,false,true,false},
//        {true,false,true,true,true,true,true,true,false,true,true,false,true,false,false,true,false,false,false,true},
//        {true,false,false,false,true,false,true,false,false,true,false,true,false,false,true,false,false,true,true,true},
//        {false,false,true,false,false,false,false,true,false,false,true,true,false,true,true,true,false,false,false,false},
//        {false,false,true,false,false,false,false,false,false,true,true,false,true,false,true,false,false,false,true,true},
//        {true,false,false,false,true,false,true,true,true,false,false,true,false,true,false,true,true,false,false,false}
//        };

        boolean[][] grid = {
                {true,false,false,false,true,true,true,false,true,false,false,false,true,false,true,false,true,false,false,true},
                {false,false,false,false,true,false,true,true,false,true,false,true,false,true,true,true,true,false,false,false}};

        System.out.println(numIslands(grid));
    }

    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public static int numIslands(boolean[][] grid) {
        int result = 0;
        int length = grid.length;
        if (grid == null || length < 1) return result;

        // one more grid for check visit
        boolean[][] check = new boolean[grid.length][];
        for (int i = 0; i < length; i++) {
            check[i] = new boolean[grid[i].length];
        }

        Queue<int[]> queue = new LinkedList<>();
        // BFS
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == true && check[i][j] == false) {
                    int[] where = {i, j};
                    queue.add(where);
                    check[i][j] = true;
                }
                while (!queue.isEmpty()) {
                    int[] now = queue.poll();
                    if (now[1]<grid[now[0]].length-1 && grid[now[0]][now[1]+1] == true && check[now[0]][now[1]+1] == false) {
                        queue.add(new int[]{now[0], now[1] + 1});
                        check[now[0]][now[1]+1] = true;
                    }

                    if (now[0]<grid.length-1 && grid[now[0]+1][now[1]] == true && check[now[0]+1][now[1]] == false) {
                        queue.add(new int[]{now[0]+1, now[1]});
                        check[now[0]+1][now[1]] = true;
                    }

                    if (now[1]>0 && grid[now[0]][now[1]-1] == true && check[now[0]][now[1]-1] == false) {
                        queue.add(new int[]{now[0], now[1]-1});
                        check[now[0]][now[1]-1] = true;
                    }

                    if (now[0]>0 && grid[now[0]-1][now[1]] == true && check[now[0]-1][now[1]] == false) {
                        queue.add(new int[]{now[0]-1, now[1]});
                        check[now[0]-1][now[1]] = true;
                    }

//                    check[now[0]][now[1]] = true;
                    if (queue.isEmpty()) result++;
                }
            }
        }

        return result;
    }
}
