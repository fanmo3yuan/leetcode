package fanmo.leetcode.algorithms;

import org.junit.Assert;

/**
 * {@see https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/}
 *
 * @author fanmo
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        return maxProfit1(prices);
    }

    private int maxProfit1(int[] prices) {
        int min = Integer.MAX_VALUE, max = 0;
        for (int price : prices) {
            if (min > price) {
                min = price;
            } else {
                max = Math.max(max, price - min);
            }
        }
        return max;
    }

    private int maxProfit2(int[] prices) {
        int sum = 0, min = prices[0], last = prices[0];
        for (int price : prices) {
            if (price < last) {
                sum += last - min;
                min = price;
            }
            last = price;
        }
        return sum + Math.max(0, last - min);
    }


    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bs = new BestTimeToBuyAndSellStock();

        Assert.assertEquals(5, bs.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        Assert.assertEquals(0, bs.maxProfit(new int[]{7, 6, 4, 3, 1}));
        Assert.assertEquals(7, bs.maxProfit(new int[]{7, 6, 4, 3, 10}));
    }

}
