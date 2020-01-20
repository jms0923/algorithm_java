package StringArray;

public class MaximumSubarray {
    public static void main(String[] args) {
//        int[] nums = {-2, 2, -3, 4, -1, 2, 1, -5, 3};
//        int[] nums = {1, 2, 3, 4};
        int[] nums = {-1};

//        System.out.println(maxSubArrayUsingDoubleFor(nums));
        System.out.println(maxSubArrayUsingMath(nums));
    }

    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public static int maxSubArrayUsingDoubleFor(int[] nums) {
        int maximum = nums[0];
        int nowSum = 0;

        for (int i=0; i<nums.length; i++){
            for (int j=i; j<nums.length; j++){
                nowSum += nums[j];
                maximum = Math.max(maximum, nowSum);
            }
            nowSum = 0;
        }

        return maximum;
    }

    public static int maxSubArrayUsingMath(int[] nums){
        int maximum = nums[0];
        int nowSum = nums[0];

        for (int i=1; i<nums.length; i++){
            nowSum = Math.max(nowSum + nums[i], nums[i]);
            maximum = Math.max(nowSum, maximum);
        }

        return maximum;
    }
}
