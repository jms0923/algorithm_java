package StringArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagrams {
    public static void main(String[] args) {
//        String s = "BACDGABCDA";
//        String p = "ABCD";
//        String s = "abab";
//        String p = "ab";
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> solved = findAnagrams(s, p);
        for(int i:solved){
            System.out.print(i + " ");
        }
    }

    /**
     * @param s: a string
     * @param p: a string
     * @return: a list of index
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> solved = new ArrayList<>();
        if (s.length() == 0 || p.length() == 0 || s == null || p == null) return solved;

        int[] pArr = new int[256];
        for (int i=0; i<p.length(); i++){
            pArr[p.charAt(i)]++;
        }

        for (int i=0; i<s.length()-p.length()+1; i++){
            int[] sArr = new int[256];

            for (int j=0; j<p.length(); j++){
                sArr[s.charAt(i+j)]++;
            }

            boolean state = true;
            for (int j=0; j<p.length(); j++){
                if (pArr[s.charAt(i+j)] != sArr[s.charAt(i+j)]){
                    state = false;
                    break;
                }
            }
            if (state){
                solved.add(i);
            }
        }
        return solved;
    }
}
