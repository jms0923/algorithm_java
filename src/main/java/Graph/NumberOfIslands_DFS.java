package Graph;

import java.util.Stack;

public class NumberOfIslands_DFS {
    public static void main(String[] args) {
        boolean[][] grid = {
                {true, true, false, false, true},
                {true, true, false, false, false},
                {false, false, false, false, false},
                {true, false, false, true, true}};

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

//        boolean[][] grid = {
//                {true,false,false,false,true,true,true,false,true,false,false,false,true,false,true,false,true,false,false,true},
//                {false,false,false,false,true,false,true,true,false,true,false,true,false,true,true,true,true,false,false,false}};

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

        for (int i=0; i<length; i++){
            for (int j=0; j<grid[i].length; j++){
                if (grid[i][j] == true){
                    dfs(grid, i, j);
                    result++;
                }
            }
        }

        return result;
    }

    public static void dfs(boolean[][] grid, int dx, int dy){
        if (dx<0 || dx>=grid.length || dy<0 ||dy>=grid[0].length || grid[dx][dy]==false) return;

        grid[dx][dy] = false;

        dfs(grid, dx+1, dy);
        dfs(grid, dx, dy+1);
        dfs(grid, dx-1, dy);
        dfs(grid, dx, dy-1);
    }
}
