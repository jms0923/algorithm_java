package StringArray;

import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args){
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperature dailyTemperature = new DailyTemperature();
        int[] solution = solveStack(nums);

        for(int i:solution){
            System.out.print(i + " ");
        }
    }

    public static int[] solveStack(int[] temperatures){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        stack.push(0);
        for(int i = 1; i<temperatures.length; i++){
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }

        return result;
    }
}
