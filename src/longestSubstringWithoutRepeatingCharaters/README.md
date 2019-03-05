# 方法1 暴力法
### 思路

逐个检查所有的子字符串，看它是否不含有重复的字符。

### 算法


        public class Solution {
            public int lengthOfLongestSubstring(String s) {
                int n = s.length();
                int ans = 0;
                for (int i = 0; i < n; i++)
                    for (int j = i + 1; j <= n; j++)
                        if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
                return ans;
            }

            public boolean allUnique(String s, int start, int end) {
                Set<Character> set = new HashSet<>();
                for (int i = start; i < end; i++) {
                    Character ch = s.charAt(i);
                    if (set.contains(ch)) return false;
                    set.add(ch);
                }
                return true;
            }
        }


# 滑动窗口

        public class Solution {
            public int lengthOfLongestSubstring(String s) {
                int n = s.length();
                Set<Character> set = new HashSet<>();
                int ans = 0, i = 0, j = 0;
                while (i < n && j < n) {
                    // try to extend the range [i, j]
                    if (!set.contains(s.charAt(j))){
                        set.add(s.charAt(j++));
                        ans = Math.max(ans, j - i);
                    }
                    else {
                        set.remove(s.charAt(i++));
                    }
                }
                return ans;
            }
        }

# 优化的滑动窗口

        public class Solution {
            public int lengthOfLongestSubstring(String s) {
                int n = s.length(), ans = 0;
                Map<Character, Integer> map = new HashMap<>(); // current index of character
                // try to extend the range [i, j]
                for (int j = 0, i = 0; j < n; j++) {
                    if (map.containsKey(s.charAt(j))) {
                        i = Math.max(map.get(s.charAt(j)), i);
                    }
                    ans = Math.max(ans, j - i + 1);
                    map.put(s.charAt(j), j + 1);
                }
                return ans;
            }
        }