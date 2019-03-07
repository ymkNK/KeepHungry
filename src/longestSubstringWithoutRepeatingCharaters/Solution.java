package longestSubstringWithoutRepeatingCharaters;

/**
 * ﻿题目：
 * Given a string, find the length of the longest substring without repeating characters.
 * <p/>
 * Example 1:
 * <p/>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p/>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p/>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 **/

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ymk on 2019/3/5.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), result = 0, i = 0, j = 0;
        Set<Character> range = new HashSet<Character>();

        while (i < n && j < n) {
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
        String input = "abcabcdabcd";
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(input));
    }
}