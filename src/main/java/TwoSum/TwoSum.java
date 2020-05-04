package TwoSum;




import java.util.HashMap;
import java.util.Map;

/**
* Created by ymkNK on 2020-05-04.
*/
public class TwoSum {


    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,int[]> numPositionMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (numPositionMap.containsKey(nums[i])) {
                int[] positions = numPositionMap.get(nums[i]);
                numPositionMap.put(nums[i], getNewPositions(positions, i));

            }else
            {
                numPositionMap.put(nums[i], new int[]{i});
            }
        }

        for (Integer num1 : numPositionMap.keySet()) {
            int num2 = target - num1;
            if (numPositionMap.containsKey(num2)) {
                int[] num1Pos = numPositionMap.get(num1);
                int[] num2Pos = numPositionMap.get(num2);

                for (int num1Po : num1Pos) {
                    for (int num2Po : num2Pos) {
                        if (num1Po != num2Po) {
                            return new int[]{num1Po,num2Po};
                        }
                    }
                }

            }
        }

        return null;
    }

    int[] getNewPositions(int[] origin,int pos) {
        int[] newPositions = new int[origin.length + 1];
        for (int i = 0; i < origin.length; i++) {
            newPositions[i] = origin[i];
        }
        newPositions[origin.length] = pos;
        return newPositions;
    }




    public int[] twoSumReal(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String[] args) {



    }
}
