package TwoSum;


/**
 * Created by ymk 2020/09/22.
 *
 **/
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {




        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] arr  = str.split(",");
        int[] b = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            b[i]=Integer.parseInt(arr[i]);
        }
        Solution solution=new Solution();
        System.out.print(solution.reversePairs(b));
    }

    private static class Solution {

//        public long reversePairs(int[] nums) {
//            long cnt = 0;
//            long len = nums.length;
//            for (int i = 0; i < len - 1; i++) {
//                for (int j = i + 1; j < len; j++) {
//                    if (nums[i] > nums[j]) {
//                        cnt++;
//                    }
//                }
//            }
//            return cnt;
//        }
        public long reversePairs(int[] nums) {
            if(nums.length<=1){
                return 0;
            }
            int length=nums.length;
            int[] temp=new int[length];
            return reversePairs(nums,0,length-1,temp);
        }

        public long reversePairs(int[] nums,int left,int right,int[] temp){
            if(left==right){
                return 0;
            }

            int mid= left + (right-left)/2;
            long letfSum=reversePairs(nums,left,mid,temp);
            long rightSum=reversePairs(nums,mid+1,right,temp);
            long mergeSum=mergeTwo(nums,left,right,mid,temp);
            return letfSum+rightSum+mergeSum;
        }

        public long mergeTwo(int[] nums,int left,int right,int mid,int[] temp){
            for(int i=left;i<=right;i++){
                temp[i]=nums[i];
            }

            long count=0;
            int i=left;
            int j=mid+1;

            for(int k=left;k<=right;k++){

                if(i==mid+1){
                    nums[k]=temp[j];
                    j++;
                }else if( j==right+1){
                    nums[k]=temp[i];
                    i++;
                }else if(temp[i]<=temp[j]){
                    nums[k]=temp[i];
                    i++;
                }else{
                    nums[k]=temp[j];
                    j++;
                    count+= (mid-i+1);
                }

            }
            return count;
        }
    }
}
