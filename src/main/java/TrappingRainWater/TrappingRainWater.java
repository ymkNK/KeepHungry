package TrappingRainWater;

/**
 * Created by ymkNK on 2020-05-05.
 */
public class TrappingRainWater {
    /**
     * 感觉此题可以使用滑动窗口来解决
     *
     * @param height 高度的数值
     * @return 能接多少雨水
     */
    public int trap1(int[] height) {
        int count = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i; j < size; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }

            count += Math.min(maxLeft, maxRight) - height[i];
        }
        return count;
    }




    public static void main(String[] args) {

    }
}
