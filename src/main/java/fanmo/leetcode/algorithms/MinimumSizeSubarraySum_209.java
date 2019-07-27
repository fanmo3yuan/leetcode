package fanmo.leetcode.algorithms;

import org.junit.Assert;

/**
 * {@see https://leetcode-cn.com/problems/minimum-size-subarray-sum/}
 *
 * @author fanmo
 * @date 2019/07/24
 */
public class MinimumSizeSubarraySum_209 {

    public int minSubArrayLen(int s, int[] nums) {

        int sum = 0;
        int length = 0, start = 0, end = 0;
        while (end < nums.length) {
            if (sum + nums[end] < s) {
                sum += nums[end++];
            } else {
                length = (0 == length) ? (end - start + 1) : Math.min(length, end - start + 1);
                sum -= nums[start++];
            }
        }

        return length;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum_209 mss = new MinimumSizeSubarraySum_209();

        Assert.assertEquals(0, mss.minSubArrayLen(10, new int[]{2, 3, 1}));
        Assert.assertEquals(1, mss.minSubArrayLen(1, new int[]{2, 3, 4}));
        Assert.assertEquals(1, mss.minSubArrayLen(1, new int[]{1}));
        Assert.assertEquals(2, mss.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        Assert.assertEquals(3, mss.minSubArrayLen(10, new int[]{2, 3, 1, 4, 5}));
        Assert.assertEquals(2, mss.minSubArrayLen(10, new int[]{2, 3, 1, 4, 5, 1, 9}));
        Assert.assertEquals(1, mss.minSubArrayLen(10, new int[]{2, 3, 1, 4, 5, 1, 9, 10}));
        Assert.assertEquals(1, mss.minSubArrayLen(10, new int[]{2, 3, 11, 4, 5, 1, 9, 10, 9, 1}));

    }

}
