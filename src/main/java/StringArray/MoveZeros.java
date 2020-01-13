package StringArray;

public class MoveZeros {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public static void main(String[] args) {
        int[] nums = {0, 2, 3, 0, 8, 5};

        moveZeros(nums);
    }
    public static void moveZeros(int[] nums){
        int index = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[index] = nums[i];
                index++;
            }
        }

        while(index < nums.length){
            nums[index] = 0;
            index++;
        }

        for(Object object : nums){
            System.out.print(object + " ");
        }
    }
}
