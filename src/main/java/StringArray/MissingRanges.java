package StringArray;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public static void main(String[] args) {
//        int[] nums = {2,3,5,50,75};
//        int lower=0, upper=99;
//        int[] nums = {};
//        int lower=1, upper=1;
        int[] nums = {-2147483648,-2147483648,0,2147483647,2147483647};
        int lower=-2147483648, upper=2147483647;

        System.out.println(findMissingRanges(nums, lower, upper));
    }

    /*
     * @param nums: a sorted integer array
     * @param lower: An integer
     * @param upper: An integer
     * @return: a list of its missing ranges
     */
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int length = nums.length;

        if (length < 1 || nums == null){
            result.add(makeString(lower, upper));
            return result;
        }

        // lower ~ index 0
        if (nums[0] > lower){
            result.add(makeString(lower, nums[0]-1));
        }

        // index 0 ~ last
        for (int i=0; i<length-1; i++){
            if (nums[i]+1 != nums[i+1] && nums[i] != nums[i+1]){
                result.add(makeString(nums[i]+1, nums[i+1]-1));
            }
        }

        // index last ~ upper
        if (nums[length-1] < upper){
            result.add(makeString(nums[length-1]+1, upper));
        }

        return result;
    }

    public static String makeString(int start, int end){
        return start == end ? String.valueOf(start) : start + "->" + end;
    }
}
