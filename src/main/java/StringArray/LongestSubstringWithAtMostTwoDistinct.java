package StringArray;

import java.util.*;

public class LongestSubstringWithAtMostTwoDistinct {
    public static void main(String[] args) {
//        String s = "eceba";
//        String s = "aaa";
//        String s = "abc";
//        String s = "";
//        String s = "a";
        String s = "cabacbbbabbb";

        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
//        System.out.println(Solution(s));
    }

    /**
     * @param s: a string
     * @return: the length of the longest substring T that contains at most 2 distinct characters
     */
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int iLength = s.length();
        if (iLength <= 1) return iLength;
        HashMap<Character, Integer> map = new HashMap<>();
        int index = 0, start = 0, end = 0, longest = 0, nowLong = 0;

        while (index < iLength-1){
            start = index;
            end = index+1;
            map.put(s.charAt(start), 1);
            while (end < iLength){
                map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0)+1);
                if (map.size() > 2) break;
                nowLong = end-start+1;
                end++;
            }
            longest = Math.max(longest, nowLong);
            index++;
            map.clear();
        }

        return longest;
    }

    public static int Solution(String s) {
        // Write your code here
        int ans = 0;
        int l = 0, r = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(r < s.length()) {
            if(map.size() <= 2) {
                char c = s.charAt(r);
                map.put(c, r);
                r++;
            }
            if(map.size() > 2) {
                int left = s.length();
                for(int i : map.values()) {
                    left = Math.min(left, i);
                }
                char c = s.charAt(left);
                map.remove(c);
                l = left + 1;
            }
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
