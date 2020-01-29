package Graph;

import java.util.Stack;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid =
                {
                        {1,1,0,1,1},
                        {0,1,1,0,0},
                        {0,0,0,0,0},
                        {1,1,0,1,1},
                        {1,0,1,1,1},
                        {1,0,1,1,1}};

        System.out.println(maxAreaOfIsland(grid));
    }

    /**
     * @param grid: a 2D array
     * @return: the maximum area of an island in the given 2D array
     */
    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        if (grid == null) return maxArea;

        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length; j++){
                if (grid[i][j] == 1){

                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }


        return maxArea;
    }

    public static int dfs(int[][] grid, int dx, int dy){
        int area = 0;
        if (dx<0 || dx>=grid.length || dy<0 || dy>=grid[dx].length || grid[dx][dy] == 0){
            return area;
        }
        else {
            area++;
            grid[dx][dy] = 0;
            area += dfs(grid, dx+1, dy);
            area += dfs(grid, dx, dy+1);
            area += dfs(grid, dx-1, dy);
            area += dfs(grid, dx, dy-1);
        }

        return area;
    }
}
