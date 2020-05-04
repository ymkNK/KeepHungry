package KthSmallestInLexicograghicalOrder;

/**
* Created by ymkNK on 2020-04-28.
*/
public class KthSmallestInLexicograghicalOrder {

    int findKthNumberMy(int n, int k) {

        /**
         * 用来存放每个数字开头的个数
         */
        int[] countMap = new int[10];

        for (int i = 1;i<10 ;i++) {
            int count = 0;
            int scale = 1;
            while (scale < n) {
                count += scale * i;
                scale *= 10;
            }
            //
            scale = scale / 10;
            if (n / scale == 1) {
                countMap[i] = count + countN(n - scale);
                break;
            }
            countMap[i] = count;
        }

        // 算出来是多少个数

        int rest = k;
        int i = 0;
        for (; i <countMap.length; i++) {
            if (rest >= countMap[i]) {
                rest -= countMap[1];
            } else {
                break;
            }
        }
        int result=0;
        int scale = 1;
        while (scale < n) {
            if (rest > scale * i) {
                rest -= scale * i;
                scale *= 10;
            } else {
                result = scale * i / 10 + rest;
            }
        }



        return result;
    }


    int countN(int n) {
        if (n < 10) {
            return n;
        }
        int count = 0;
        for (int i = 1;i<10 ;i++) {
            int scale = 1;
            while (scale < n) {
                count += scale * i;
                scale *= 10;
            }
            //
            scale = scale / 10;
            if (n / scale == 1) {
                count += countN(n-scale);
                break;
            }
            count += scale*i;
        }
        return count;
    }

    /**
     *  标准答案
     */
    public int findKthNumber(int n, int k) {
        // cur游标,表示当前位置的数值
        int cur = 1;
        // k就是子树剩下的个数
        k--;
        while (k > 0) {
            // step 当前这个节点的子节点个数
            // first 当前的数
            // last 当前的下一个数
            long step = 0, first = cur, last = cur + 1;
            while (first <= n) {
                step += Math.min(last, (long) (n + 1)) - first;
                //
                first *= 10;
                last *= 10;
            }

            if (step > k) {
                //在树里
                k--;
                cur *= 10;
            }
            if (step <= k) {
                //不在树里
                k -= step;
                ++cur;
            }
        }
        return cur;
    }
    /**
     *
     * @param args
     */
    public static void main(String[] args) {



    }
}
