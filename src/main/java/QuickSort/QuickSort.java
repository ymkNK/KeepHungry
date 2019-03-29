package QuickSort;

import com.google.common.base.Joiner;

/**
 * Created by ymk on 2019/3/29.
 * 这个类主要是用来实现快速排序的
 */
public class QuickSort {

    public static <T extends Comparable> void sort(T[] arr, int left, int right) {
        if (left >= right)
            return;
        int i = left, j = right;
        T key = arr[i];

        while (i < j) {
            while (arr[j].compareTo(key) >= 0 && i < j) {
                j--;
            }
            //j找到第一个比key小的值,i和j交换值
            swap(arr, i, j);
            while (arr[i].compareTo(key) <= 0 && i < j) {
                i++;
            }
            //i找到第一个比key大的值,i和j交换值
            swap(arr, i, j);
        }
        //开始递归
        sort(arr, left, i);
        sort(arr, i + 1, right);
    }

    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 325, 52, 34, 5346, 23, 23, 56, 74, 34, 634, 74, 34};
        Joiner joiner = Joiner.on(",");
        System.out.println(joiner.join(arr));
        sort(arr, 0, arr.length - 1);
        System.out.println(joiner.join(arr));
    }

}
