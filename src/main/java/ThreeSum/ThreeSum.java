package ThreeSum;

import java.util.*;

/**
* Created by ymkNK on 2020-05-06.
*/
public class ThreeSum {
    public List<List<Integer>> threeSumMy(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> numMap = new HashMap<>();
        // 存下有多少数，同时也存下每一个数字出现的频率
        for (int num:nums) {
            if (numMap.containsKey(num)) {
                Integer count = numMap.get(num);
                count++;
                numMap.put(num, count);
            } else {
                numMap.put(num, 1);
            }
        }

        HashSet<String> key = new HashSet<>();
        for (Integer a : numMap.keySet()) {
            Integer countA = numMap.get(a);
            countA--;
            numMap.put(a, countA);
            for (Integer b : numMap.keySet()) {
                Integer countB = numMap.get(b);
                if (countB <= 0) {
                    continue;
                }
                countB--;
                numMap.put(b, countB);

                Integer c = 0 - a - b;

                if (numMap.containsKey(c)) {
                    Integer countC = numMap.get(c);
                    if (countC >= 1) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(a);
                        temp.add(b);
                        temp.add(c);
                        temp.sort(Comparator.naturalOrder());
                        String keyHash = temp.toString();
                        if (!key.contains(keyHash)) {
                            key.add(keyHash);
                            result.add(temp);
                        }
                    }
                }

                countB++;
                numMap.put(b, countB);
            }
            countA++;
            numMap.put(a, countA);
        }

        return result;
    }

    public static void main(String[] args) {



    }
}
