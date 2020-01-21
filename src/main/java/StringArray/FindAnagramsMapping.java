package StringArray;

import java.util.HashMap;

public class FindAnagramsMapping {
    public static void main(String[] args) {
        int[] A = {12, 28, 46, 32, 50};
        int[] B = {50, 12, 32, 46, 28};

        int[] solved = anagramMappings(A, B);

        for (int i:solved){
            System.out.print(i + " ");
        }
    }

    /**
     * @param A: lists A
     * @param B: lists B
     * @return: the index mapping
     */
    public static int[] anagramMappings(int[] A, int[] B) {
        int length = A.length;
        int[] sovled = new int[length];

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<length; i++){
            map.put(B[i], i);
        }

        for (int i=0; i<length; i++){
            sovled[i] = map.get(A[i]);
        }

        return sovled;
    }
}
