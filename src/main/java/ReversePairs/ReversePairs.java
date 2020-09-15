package ReversePairs;

/**
* Created by ymkNK on 2020-09-15.
*/
public class ReversePairs {

    public int reversePairs(int[] nums) {
        if(nums.length<=1){
            return 0;
        }
        int length=nums.length;
        int[] temp=new int[length];
        return reversePairs(nums,0,length-1,temp);
    }
    public int reversePairs(int[] nums,int left,int right,int[] temp){
        if(left==right){
            return 0;
        }
        int mid= left + (right-left)/2;
        int letfSum=reversePairs(nums,left,mid,temp);
        int rightSum=reversePairs(nums,mid+1,right,temp);
        int mergeSum=mergeTwo(nums,left,right,mid,temp);
        return letfSum+rightSum+mergeSum;
    }
    public int mergeTwo(int[] nums,int left,int right,int mid,int[] temp){
        for(int i=left;i<=right;i++){
            temp[i]=nums[i];
        }

        int count=0;
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

    public static void main(String[] args) {
        int[] input=new int[49999];
        for(int i=0;i<input.length;i++){
//            input[i]= (int) (Math.random() * 100);
            input[i]=49998-i;
        }


        System.out.println("input:");
        System.out.print("[");
        for(int i=0;i<input.length;i++){
            if (i!=input.length-1){
                System.out.print(input[i]+",");
            }else {
                System.out.print(input[i]);
            }
        }
        System.out.println("]\noutput:");
        ReversePairs reversePairs = new ReversePairs();
        System.out.println(reversePairs.reversePairs(input));
    }
}
