# 题目

There are two sorted arrays nums1 and nums2 of size m and n respectively.  

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).  

You may assume nums1 and nums2 cannot be both empty.  

### Example 1:  

        nums1 = [1, 3]
        nums2 = [2]

The median is 2.0  
### Example 2:  

        nums1 = [1, 2]
        nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5   

# 想法
刚开始的时候,想把两个数组放在一起,放在一个数组当中,然后排个序,然后找到中间的数.
system.arraycopy  
Array.sort  