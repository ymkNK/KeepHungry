package HappyNumber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
* Created by ymkNK on 2020-08-24.
*/

class HappyNumber {
    Map<Character,Integer> powerMap=new HashMap<Character,Integer>(){{
        put('0',0);
        put('1',1);
        put('2',4);
        put('3',9);
        put('4',16);
        put('5',25);
        put('6',36);
        put('7',49);
        put('8',64);
        put('9',81);
    }};

    private Set<Integer> historySet=new HashSet<>();

    public boolean isHappy(int n) {
        if(n==1){
            return true;
        }
        if (historySet.contains(n)) {
            return false;
        }
        historySet.add(n);

        String numberString=String.valueOf(n);
        char[] numArray=numberString.toCharArray();
        int result=0;
        for(char num: numArray)
        {
            int temp=powerMap.get(num);
            result+=temp;
        }
        return isHappy(result);
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        boolean happy = happyNumber.isHappy(19);
        System.out.println(happy);
    }
}