package LongestPalindromicSubstring;

/**
 * Created by ymk on 2019/3/10.
 */
public class Solution {
    public String longestPalindrome(String s) {

        //将字符串扩展
        String manacherString="#";
        for (int i=0;i<s.length();i++)
        {
            manacherString+=s.charAt(i)+"#";
        }

        //用来存放回文的半径
        int[] radius = new int[manacherString.length()];

        /**
         * 最右回文边界,指的是这个位置及之前的文职的回文字符串,所到达的最右边的地方
         **/
        int R=-1;

        /**
         * Created by ymk.
         * 最右回文中心的对称中心
         **/
        int c=-1;



        /**
         * Created by ymk.
         *
         **/
        int max = Integer.MIN_VALUE;


        return manacherString;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.longestPalindrome("abcabccba"));
    }
}
