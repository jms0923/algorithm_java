package StringArray;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs =  {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> solved = groupAnagrams(strs);
        System.out.println(solved);

//        for (List<String> list:solved){
//            for (String str:list){
//                System.out.print(str + " ");
//            }
//            System.out.println();
//        }
    }

    /**
     * @param strs: the given array of strings
     * @return: The anagrams which have been divided into groups
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> solved = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();
        if (strs == null || strs.length == 0) return solved;

        for (String s:strs){
            char[] cKey = s.toCharArray();
            Arrays.sort(cKey);
            String strKey = String.valueOf(cKey);

            if (map.containsKey(strKey)){
                map.get(strKey).add(s);
            }
            else{
                List<String> value = new ArrayList<String>();
                value.add(s);
                map.put(strKey, value);
            }
        }
        solved.addAll(map.values());

        return solved;
    }
}
