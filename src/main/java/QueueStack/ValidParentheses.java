package QueueStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
//        String s="{()}";
//        String s= "([)]";
//        String s = "()[]{}";
//        String s = "{";
//        String s = "(])";
//        String s = "()";
//        String s = "[])";
        String s = "{}])";

        System.out.println(isValidParentheses(s));
    }

    /**
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public static boolean isValidParentheses(String s) {
        boolean isValid = false;
        if (s == null || s.length() < 2) return isValid;
        if (s.length() % 2 == 1) return isValid;

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);

           switch (c){
               case '}':
                   if (!stack.isEmpty() && stack.peek().equals(map.get(c))) stack.pop();
                   else return isValid;
                   break;
               case ')':
                   if (!stack.isEmpty() && stack.peek().equals(map.get(c))) stack.pop();
                   else return isValid;
                   break;
               case ']':
                   if (!stack.isEmpty() && stack.peek().equals(map.get(c))) stack.pop();
                   else return isValid;
                   break;
               default:
                   stack.push(c);
                   break;
           }
        }

        return stack.isEmpty();
    }
}
