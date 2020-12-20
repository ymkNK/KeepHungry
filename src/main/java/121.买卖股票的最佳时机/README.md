# 2020-07-17 BestTimeToBuyAndSellStock
[地址](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/)

给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

注意：你不能在买入股票前卖出股票。


## 原理

### 自我思考
滑动窗口，两个指针同时遍历，但是需要先入手的价格必须低于出手的价格

### 方式一 暴力解答

```
   int benefit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                int tempMoney = prices[j] - prices[i];
                benefit = Math.max(tempMoney, benefit);
            }
        }
        return benefit;
```

### 方式二 滑动窗口