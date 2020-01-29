package StringArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrappingRainWater {
    public static void main(String[] args) {
//        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
//        int[] heights = {0, 1, 0};
//        int[] heights = {1, 200, 1};
//        int[] heights = {100, 0, 100};
        int[] heights = {100,50,99,50,100,50,99,50,100,50};
//        int[] heights = {10,0,1,0,1,0,1,0,10};

        System.out.println(trapRainWater(heights));
    }

    /**
     * @param heights: a list of integers
     * @return: a integer
     */
    public static int trapRainWater(int[] heights) {
        if (heights == null || heights.length<3) return 0;
        int trapped = 0;
        int width = heights.length;
        int leftMax = heights[0], rightMax = heights[width-1];
        int left[] = new int[width], right[] = new int[width];

        // fill left, right wall
        for (int i=0; i<width; i++){
            if (leftMax > heights[i]){
                left[i] = leftMax;
            }
            else {
                leftMax = heights[i];
                left[i] = heights[i];
            }

            if (rightMax > heights[width-i-1]){
                right[width-i-1] = rightMax;
            }
            else {
                rightMax = heights[width-i-1];
                right[width-i-1] = heights[width-i-1];
            }
        }

        for (int i=0; i<width; i++){
            trapped += Math.min(left[i], right[i]) - heights[i];
        }

        return trapped;
    }
}
