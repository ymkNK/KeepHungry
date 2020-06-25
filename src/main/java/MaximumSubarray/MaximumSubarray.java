package MaximumSubarray;

/**
* Created by ymkNK on 2020-05-05.
*/
public class MaximumSubarray {


    public static int maxSubArrayTimeOutByForce(int[] nums) {
        int max =  -2147483647;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int temp = 0;
                for (int iterator = i; iterator <= j; iterator++) {
                    temp = temp + nums[iterator];
                }
                max = Math.max(max, nums[i]);
                max = Math.max(max, temp);
            }
        }
        return max;
    }

    public static int maxSubArrayByTanXin(int[] nums) {
        int max =  -2147483647;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(sum, max);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }


    public static int maxSubArrayByDynamicPlan(int[] nums) {
        int max =  -2147483647;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }



    public static void main(String[] args) {

        int[] temp = new int[]{-1, -2};


    }
}
