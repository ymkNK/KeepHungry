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

        //最右回文边界R
        int R=-1;
        //最右回文边界的对称中心C

        int max = Integer.MIN_VALUE;


        return manacherString;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.longestPalindrome("abcabccba"));
    }
}
