package QueueStack;

import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {
        String[] ops = {"5", "-2", "4", "C", "D", "9", "+", "+"};
//        String[] ops = {"5", "2", "C", "D", "+"};

        System.out.println(calPoints(ops));
    }

    /**
     * @param ops: the list of operations
     * @return: the sum of the points you could get in all the rounds
     */
    public static int calPoints(String[] ops) {
        int finalScore = 0;
        if (ops == null || ops.length == 0) return 0;

        Stack<Integer> stack = new Stack<>();

        for (String s : ops) {
            if (s.equals("C")) {
                int temp = stack.pop();
                finalScore -= temp;
            }
            else if (s.equals("D")) {
                int temp = stack.peek()*2;
                stack.push(temp);
                finalScore += temp;
            }
            else if (s.equals("+")) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2);
                stack.push(temp1);
                stack.push(temp1 + temp2);
                finalScore += temp1 + temp2;
            }
            else {
                int temp = Integer.parseInt(s);
                finalScore += temp;
                stack.push(temp);
            }
        }

        return finalScore;
    }
}
