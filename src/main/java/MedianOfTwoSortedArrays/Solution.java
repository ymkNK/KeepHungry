package MedianOfTwoSortedArrays;

import java.awt.*;
import java.util.Arrays;

/**
 * Created by ymk on 2019/3/8.
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len=nums1.length+nums2.length;
        int[] numTotal=new int[len];
        System.arraycopy(nums1,0,numTotal,0, nums1.length);
        System.arraycopy(nums2,0,numTotal,nums1.length,nums2.length);
        Arrays.sort(numTotal);

        return len%2==0?(numTotal[len/2]+numTotal[len/2-1])/2.0:(numTotal[len/2])*1.0;
    }
}