package StringArray;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";

        System.out.println(numJewelsInStones(J, S));
    }

    /**
     * @param J: the types of stones that are jewels
     * @param S: representing the stones you have
     * @return: how many of the stones you have are also jewels
     */
    private static int numJewelsInStones(String J, String S) {
        if (J.isEmpty() || S.isEmpty()) return 0;
        int numOfJewels = 0;

        Set<Character> jewels = new HashSet<>();
        for (char i:J.toCharArray()){
            jewels.add(i);
        }

        for (char i:S.toCharArray()){
            if (jewels.contains(i)){
                numOfJewels++;
            }
        }

        return numOfJewels;
    }
}

