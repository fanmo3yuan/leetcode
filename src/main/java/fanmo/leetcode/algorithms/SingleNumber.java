package fanmo.leetcode.algorithms;

import org.junit.Assert;

/**
 * {@see https://leetcode-cn.com/problems/single-number/}
 *
 * @author fanmo
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();
        Assert.assertEquals(3, sn.singleNumber(new int[]{3}));
        Assert.assertEquals(2, sn.singleNumber(new int[]{1, 2, 1}));
        Assert.assertEquals(4, sn.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }
}
