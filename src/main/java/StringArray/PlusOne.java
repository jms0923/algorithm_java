package StringArray;

public class PlusOne {
    public static void main(String[] args){
//        int[] digits = {1,2,3};
//        int[] digits = {9,9,8};
//        int[] digits = {9,9,9};
        int[] digits = {8,9,9,9};

        int[] solved = plusOne(digits);

        for (int i:solved){
            System.out.print(i + " ");
        }
    }

    /**
     * @param digits: a number represented as an array of digits
     * @return: the result
     */
    public static int[] plusOne(int[] digits) {
        int size = digits.length;
        for (int i=size-1; i>=0; i--){
            if (digits[i] != 9){
                digits[i]++;
                break;
            }
            else {
                digits[i] = 0;
            }
        }

        if (digits[0] == 0){
            int[] solved = new int[size+1];
            solved[0] = 1;
            return solved;
        }
        return digits;
    }
}
