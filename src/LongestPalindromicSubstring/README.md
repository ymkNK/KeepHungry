# 题目

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.  

### Example 1:  

        Input: "babad"
        Output: "bab"
        Note: "aba" is also a valid answer.
### Example 2:

        Input: "cbbd"
        Output: "bb"
        
# 想法


## 反向回文的方法
第一种想法,就是将字符串反序,然后找到最大的公共字符串,但是这样的做法会有一种bug

        example: "abcdesgcba"
       
这样找到在的最大回文就是abc其实并不是.

## 暴力法

选出所有字符串可能的开始和结束位置,并且检验它是不是回文,这样的时间复杂度很高,O(n^3)

## 中心扩展法

与因为回文中心的两侧互为镜像,回文恶意从它的中心展开,并且只有2n-1个这样的中心(如果是偶数长度的字母,中心就是在两个字母中间)  

## 动态规划

主要是为了改进暴力法

## Manacher 算法
- >[回文数组马拉车算法](https://www.jianshu.com/p/116aa58b7d81)
- >[马拉车算法原理和实现](https://www.cnblogs.com/z360/p/6375514.html)

Manacher算法提供了一种巧妙地办法，将长度为奇数的回文串和长度为偶数的回文串一起考虑，具体做法是，在原字符串的每个相邻两个字符中间插入一个分隔符，同时在首尾也要添加一个分隔符，分隔符的要求是不在原串中出现，一般情况下可以用#号  



