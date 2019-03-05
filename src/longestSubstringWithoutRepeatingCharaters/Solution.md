# 方法1 暴力法
### 思路

逐个检查所有的子字符串，看它是否不含有重复的字符。

### 算法

假设我们有一个函数 boolean allUnique(String substring) ，如果子字符串中的字符都是唯一的，它会返回true，否则会返回false。 我们可以遍历给定字符串 s 的所有可能的子字符串并调用函数 allUnique。 如果事实证明返回值为true，那么我们将会更新无重复字符子串的最大长度的答案。

现在让我们填补缺少的部分：

为了枚举给定字符串的所有子字符串，我们需要枚举它们开始和结束的索引。假设开始和结束的索引分别为 ii 和 jj。那么我们有 0 \leq i \lt j \leq n0≤i<j≤n （这里的结束索引 jj 是按惯例排除的）。因此，使用 ii 从0到 n - 1n−1 以及 jj 从 i+1i+1 到 nn 这两个嵌套的循环，我们可以枚举出 s 的所有子字符串。

要检查一个字符串是否有重复字符，我们可以使用集合。我们遍历字符串中的所有字符，并将它们逐个放入 set 中。在放置一个字符之前，我们检查该集合是否已经包含它。如果包含，我们会返回 false。循环结束后，我们返回 true。

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

### 复杂度分析
时间复杂度：O(n^3)O(n
3
 ) 。

要验证索引范围在 [i, j)[i,j) 内的字符是否都是唯一的，我们需要检查该范围中的所有字符。 因此，它将花费 O(j - i)O(j−i) 的时间。

对于给定的 i，对于所有 j \in [i+1, n]j∈[i+1,n] 所耗费的时间总和为：

\sum_{i+1}^{n}O(j - i) ∑
i+1
n
​
 O(j−i)

因此，执行所有步骤耗去的时间总和为：

O\left(\sum_{i = 0}^{n - 1}\left(\sum_{j = i + 1}^{n}(j - i)\right)\right) = O\left(\sum_{i = 0}^{n - 1}\frac{(1 + n - i)(n - i)}{2}\right) = O(n^3) O(∑
i=0
n−1
​
 (∑
j=i+1
n
​
 (j−i)))=O(∑
i=0
n−1
​

2
(1+n−i)(n−i)
​
 )=O(n
3
 )