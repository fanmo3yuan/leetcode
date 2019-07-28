package fanmo.leetcode.algorithms;

import org.junit.Assert;

/**
 * {@see https://leetcode-cn.com/problems/max-consecutive-ones-iii/}
 *
 * @author fanmo
 * @date 2019/07/28
 */
public class MaxConsecutiveOnes3_1004 {

    public int longestOnes(int[] nums, int count) {

        if (null == nums || 0 == nums.length) {
            return 0;
        }
        if (count >= nums.length) {
            return nums.length;
        }

        int left = 0, right = 0, reserve = 0;
        int maxLength = 0;
        for (; right < nums.length; right++) {
            if (0 == nums[right]) {
                if (reserve < count) {
                    reserve++;
                } else {
                    maxLength = Math.max(maxLength, right - left);
                    int i = left;
                    for (; i < right; i++) {
                        if (0 == nums[i]) {
                            break;
                        }
                    }
                    left = i + 1;
                }
            }
        }
        return Math.max(maxLength, right - left);
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes3_1004 mco = new MaxConsecutiveOnes3_1004();

        Assert.assertEquals(6, mco.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        Assert.assertEquals(10, mco.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
        Assert.assertEquals(4, mco.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 0));
        Assert.assertEquals(11, mco.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 4));
        Assert.assertEquals(11, mco.longestOnes(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 11));
        Assert.assertEquals(5, mco.longestOnes(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 5));
        Assert.assertEquals(0, mco.longestOnes(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 0));
    }

}
