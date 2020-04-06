package CheckInClusion;

import java.util.HashMap;
import java.util.Map;

/**
* Created by ymkNK on 2020-04-07.
*/
public class CheckInClusion {

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];
        int count = 0;
        // 记录个子的频率
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (s1Map[i] == s2Map[i]) {
                count++;
            }
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int right = s2.charAt(i + s1.length()) - 'a';
            int left = s2.charAt(i)-'a';
            if (count == 26) {
                return true;
            }
            // 滑动窗口右边
            s2Map[right]++;
            if (s2Map[right] == s1Map[right]) {
                count++;
            } else if (s2Map[right] == s1Map[right] + 1) {
                count--;
            }
            // 滑动窗口左边
            s2Map[left]--;
            if (s2Map[left] == s1Map[left]) {
                count++;
            } else if (s2Map[left] ==s1Map[left] - 1) {
                count--;
            }
        }
        return count == 26;
    }


    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));


    }
}
