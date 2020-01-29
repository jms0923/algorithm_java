package Graph;

import com.sun.org.glassfish.gmbal.ParameterNames;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public static void main(String[] args) {
/*        String start = "hit";
        String end = "cog";
        HashSet<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");*/

        String start = "a";
        String end = "c";
        HashSet<String> dict = new HashSet<>();
        dict.add("a");
        dict.add("b");
        dict.add("c");

        System.out.println(ladderLength(start, end, dict));
    }

    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public static int ladderLength(String start, String end, Set<String> dict) {
        int pathLength = 0;
        if (start.equals(end)) return 1;
        if (dict.size() == 0 || dict == null) return pathLength;

        HashSet<String> set = new HashSet<>();
        set.add(start);
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        pathLength++;
        dict.add(end);

        while (queue.size() != 0){
            int size = queue.size();
            pathLength++;
            for (int i=0; i<size; i++){
                String now = queue.poll();
                for (String s:dict){
                    int checked = checkOneDifferent(now, s);
                    if (checked != now.length() && checked != -1 && !set.contains(s)){
                        if (s.equals(end)) return pathLength;
                        queue.offer(s);
                        set.add(s);
                    }
                }
            }
        }

        return pathLength;
    }


    /*
    * @param first: a string
    * @param second: a stsring
    * @return: An integer
    * */
    public static int checkOneDifferent(String first, String second){
        int where = 0;
        int howManyDifferent = 0;
        int differentIndex = 0;

        for (int i=0; i<first.length(); i++){
            if (first.charAt(i) == second.charAt(i)) where++;
            else {
                howManyDifferent++;
                differentIndex = where;
            }
            if (howManyDifferent>1) return -1;
        }

        if (howManyDifferent == 1) return differentIndex;


        return where;
    }
}
