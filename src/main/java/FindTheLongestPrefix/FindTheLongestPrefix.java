package FindTheLongestPrefix;


import java.util.Collections;

/**
 * Created by ymkNK on 2020-04-05.
 */
public class FindTheLongestPrefix {


    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String result = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
                if (result.isEmpty()) {
                    return "";
                }
            }
        }
        return result;
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        char[] res = strs[0].toCharArray();
        int end = strs[0].length();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            end = Math.min(end, chars.length);
            for (int i = 0; i < Math.min(str.length(), res.length); i++) {
                if (res[i] != chars[i]) {
                    end = Math.min(end, i);
                    break;
                }
            }
        }
        return String.valueOf(res, 0, end);
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
