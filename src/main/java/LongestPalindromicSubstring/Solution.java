package LongestPalindromicSubstring;

import java.util.HashMap;

/**
 * Created by ymk on 2019/3/10.
 */
public class Solution {
    public String longestPalindrome(String s) {

        //将字符串扩展
        String manacherString = "#";
        for (int i = 0; i < s.length(); i++) {
            manacherString += s.charAt(i) + "#";
        }

        //用来存放回文的半径
        int[] radius = new int[manacherString.length()];

        /**
         * 最右回文边界,指的是这个位置及之前的文职的回文字符串,所到达的最右边的地方
         **/
        int R = -1;

        /**
         * Created by ymk.
         * 最右回文中心的对称中心
         **/
        int c = -1;

        /**
         * Created by ymk.
         * 用来存最大的回文半径
         **/
        int max = Integer.MIN_VALUE;

        /**
         * Created by ymk.
         * 用来存最大回文半径所对应的位置
         **/
        HashMap<Integer, String> result = new HashMap<Integer, String>();


        for (int i = 0; i < radius.length; i++) {
            /**
             * Created by ymk.
             * 根据R和i的位置关系来进行每个位置的回文半径的设定
             **/
            radius[i] = R > i ? Math.min(radius[2 * c - i], R - i + 1) : 1;

            /**
             * Created by ymk.
             * 用于判断回文
             **/
            while (i + radius[i] < manacherString.length() && i - radius[i] > -1) {
                if (manacherString.charAt(i - radius[i]) == manacherString.charAt(i + radius[i])) {
                    radius[i]++;
                } else {
                    break;
                }
            }
            /**
             * Created by ymk.
             * 扩张最右回文边界
             **/
            if (i + radius[i] > R) {
                R = i + radius[i] - 1;
                c = i;
            }

            max = Math.max(max, radius[i]);
            if (max == radius[i]) {
                String temp = manacherString.substring(i - max + 1, i + max - 1);
                temp = temp.replaceAll("#", "");
                result.put(max, temp);
            }
        }

        return result.get(max);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("abcabccbacasdfghjkjhgfdsdfghj"));
    }
}
