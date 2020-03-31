package LongestSubstringWithoutRepeating;

import java.util.HashMap;
import java.util.HashSet;

/**
* Created by ymkNK on 2020-04-01.
*/
public class LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String s) {
        int length=s.length(),i=0,j=0,result=0;
        HashSet<Character> range = new HashSet<>();
        while (i < length && j < length) {
            if (!range.contains(s.charAt(j))) {
                range.add(s.charAt(j++));
                result = Math.max(result, j - i);
            } else {
                range.remove(s.charAt(i++));
            }
        }
        return result;
    }


    public static void main(String[] args) {

        String temp = "pwwkew";
        System.out.println(lengthOfLongestSubstring(temp));
    }
}
