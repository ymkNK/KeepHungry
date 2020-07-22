package SearchInRotatedSortedArray;

/**
 * Created by ymkNK on 2020-07-21.
 */
public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    public static int search(int[] nums, int left, int right, int target) {
        int index = -1;
        if (left >= right) {
            if (nums[left] == target) {
                index = left;
            }
            if (nums[right] == target) {
                index = right;
            }
            return index;
        }

        if (nums[left] < nums[right] && nums[left] > target) {
            return index;
        }

        int partition = left + ((right - left) / 2);

        int leftSearch = search(nums, left, partition - 1, target);
        if (leftSearch != -1) {
            index = leftSearch;
            return index;
        }
        int rightSearch = search(nums, partition, right, target);
        if (rightSearch != -1) {
            index = rightSearch;
        }

        return index;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(SearchInRotatedSortedArray.search(nums, 0));


    }
}
