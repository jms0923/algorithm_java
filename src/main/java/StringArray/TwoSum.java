package StringArray;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        /**
         * @param numbers: An array of Integer
         * @param target: target = numbers[index1] + numbers[index2]
         * @return: [index1, index2] (index1 < index2)
         */

        int[] nums = {2, 8, 11, 21};
        int target = 10;

        TwoSum twoSum = new TwoSum();
        int[] solutionFor = twoSum.solveFor(nums, target);
        int[] solutionMap = twoSum.solveMap(nums, target);

        System.out.println(solutionFor[0] + " " + solutionFor[1]);
        for(int i:solutionMap){
            System.out.print(i + " ");
        }

    }

    public int[] solveFor(int[] numbers, int target){
        int[] result = new int[2];

        for (int i = 0; i < numbers.length - 1; i++){
            for (int j = 1; j < numbers.length; j++){
                if (numbers[i] + numbers[j] == target){
                    result[0] = i;
                    result[1] = j;

                    return result;
                }
            }
        }

        return result;
    }

    public int[] solveMap(int[] numbers, int target){
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i<numbers.length; i++){
            if (map.containsKey(numbers[i])){
                result[0] = map.get(numbers[i]);
                result[1] = i;

                return result;
            }
            else{
                map.put(target - numbers[i], i);
            }
        }

        return result;
    }

}
