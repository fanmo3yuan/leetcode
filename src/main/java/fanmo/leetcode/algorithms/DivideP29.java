package fanmo.leetcode.algorithms;

import org.junit.Assert;

/**
 * @author fanmo
 */
public class DivideP29 {

    public int divide(int dividend, int divisor) {
        if (dividend == divisor) {
            return 1;
        }
        if (1 == divisor) {
            return dividend;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean flag = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        int times = binary(Math.abs(dividend), 0, Math.abs(divisor));
        return flag ? 0 - times : times;
    }

    private int binary(int target, int times, int divisor) {
        if (target < divisor) {
            return times;
        }
        int res = divisor;
        int cur = 1;
        while (res + res <= target && res + res >= 0) {
            res += res;
            cur = cur + cur;
        }
        return binary(target - res, times + cur, divisor);
    }

    public static void main(String[] args) {
        DivideP29 dp = new DivideP29();
        Assert.assertEquals(1, dp.divide(1, 1));
        Assert.assertEquals(2, dp.divide(2, 1));
        Assert.assertEquals(2, dp.divide(4, 2));
        Assert.assertEquals(1, dp.divide(999, 999));
        Assert.assertEquals(111, dp.divide(999, 9));
        Assert.assertEquals(5, dp.divide(10, 2));
        Assert.assertEquals(5, dp.divide(15, 3));
        Assert.assertEquals(7, dp.divide(15, 2));
        Assert.assertEquals(3, dp.divide(15, 4));
        Assert.assertEquals(1, dp.divide(15, 10));
        Assert.assertEquals(0, dp.divide(15, 100));
        Assert.assertEquals(-3, dp.divide(-15, 4));
        Assert.assertEquals(-3, dp.divide(15, -4));
        Assert.assertEquals(3, dp.divide(-15, -4));
    }

}
