package StringArray;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
//        int[][] matrix = {
//                { 1, 2, 3 },
//                { 4, 5, 6 },
//                { 7, 8, 9 } };
//        int[][] matrix={{10}};
//        int[][] matrix={{1, 2}};
        int[][] matrix={{1}, {2}};
//        int[][] matrix = {
//                {  1,  2,  3,  4 },
//                {  6,  7,  8,  9 },
//                { 10, 11, 12, 13 },
//                { 20, 21, 22, 23 }};

        List<Integer> solved = spiralOrder(matrix);
        for (int i:solved)
            System.out.print(i + " ");
    }

    /**
     * @param matrix: a matrix of m x n elements
     * @return: an integer list
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> solved = new ArrayList<>();

        if (matrix == null || matrix.length == 0) return solved;

        int rowMax = matrix.length-1;
        int colMax = matrix[0].length-1;
        int rowNow = 0, colNow = 0, rowStart = 0, colStart = 0;

        while (rowMax>=rowStart){
            for (colNow=colStart; colNow<=colMax; colNow++){
                solved.add(matrix[rowNow][colNow]);
            }
            rowStart++;
            if (check(rowStart, rowMax)) break;

            colNow--;
            for (rowNow=rowStart; rowNow<=rowMax; rowNow++){
                solved.add(matrix[rowNow][colNow]);
            }
            colMax--;
            if (check(colStart, colMax)) break;

            rowNow--;
            for (colNow=colMax; colNow>=colStart; colNow--){
                solved.add(matrix[rowNow][colNow]);
            }
            rowMax--;
            if (check(rowStart, rowMax)) break;

            colNow++;
            for (rowNow=rowMax; rowNow>=rowStart; rowNow--){
                solved.add(matrix[rowNow][colNow]);
            }
            colStart++;
            if (check(colStart, colMax)) break;

            rowNow++;
        }

        System.out.println("colMax, rowMax => " + colMax + " " + rowMax);
        System.out.println("colStart, rowStart => " + colStart + " " + rowStart);
        System.out.println("colNow, rowNow => " + colNow + " " + rowNow);

        return solved;
    }

    public static boolean check(int start, int max){
        if (start > max) return true;
        else return false;
    }
}
