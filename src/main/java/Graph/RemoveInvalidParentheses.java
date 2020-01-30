package Graph;

import java.util.*;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        String s = "(a)())()";

        System.out.println(removeInvalidParentheses(s));
    }

    /**
     * @param s: The input string
     * @return: Return all possible results
     */
    public static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;

        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);
        boolean found = false;

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++){
                String nowS = queue.poll();
                if (isValid(nowS)){
                    result.add(nowS);
                    found = true;
                }
                if (found) continue;

                for (int j=0; j<nowS.length(); j++){
                    if (nowS.charAt(j) != '(' && nowS.charAt(j) != ')') continue;
                    String nextS = nowS.substring(0, j) + nowS.substring(j+1);
                    if (!visited.contains(nextS)){
                        queue.offer(nextS);
                        visited.add(nextS);
                    }
                }
            }
        }

        return result;
    }

    static boolean isValid(String s) {
        int count = 0;

        for (char c:s.toCharArray()){
            if (c =='(') count++;

            else if (c == ')'){
                if (count <= 0) return false;
                count--;
            }
        }

        if (count == 0) return true;
        return false;
    }
}
