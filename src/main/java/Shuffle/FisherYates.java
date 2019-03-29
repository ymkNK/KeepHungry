package Shuffle;

import com.google.common.base.Joiner;
import com.google.common.collect.Interner;
import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.*;

/**
 * Created by ymk on 2019/3/28.
 * 这个算法主要是用来实现洗牌算法的
 */
public class FisherYates {

    public static void byMyWayFisherYates(Integer[] raw) {
        Random rnd = new Random();
        //nextInt(n)生成的值范围是[0,n)的
        for (int i = raw.length; i>1; i--) {
            swap(raw,i-1,rnd.nextInt(i));
        }
    }


    public static void swap(Integer[] raw, int i, int j) {
        Integer temp = raw[i];
        raw[i] = raw[j];
        raw[j] = temp;
    }


    public static void main(String[] args) {
        Integer[] raw = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        List<Integer> pokers = Arrays.asList(raw);
        Joiner joiner = Joiner.on(",");
        System.out.println(joiner.join(pokers));
        Collections.shuffle(pokers);
        System.out.println(joiner.join(pokers));

        Integer[] newRaw = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        System.out.println(joiner.join(newRaw));
        byMyWayFisherYates(newRaw);
        System.out.println(joiner.join(newRaw));
    }
}
