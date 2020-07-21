package BestTimeToBuyAndSellStock;

import java.time.OffsetDateTime;

/**
* Created by ymkNK on 2020-07-17.
*/
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int benefit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                int tempMoney = prices[j] - prices[i];
                benefit = Math.max(tempMoney, benefit);
            }
        }
        return benefit;
    }

    public int maxProfitWayTwo(int[] prices) {
        int benefit = 0;
        int lowestPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            lowestPrice = Math.min(lowestPrice, price);
            benefit = Math.max(benefit, price - lowestPrice);
        }
        return benefit;
    }

    public static void main(String[] args) {



    }
}
