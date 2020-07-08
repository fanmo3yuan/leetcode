package fanmo.leetcode.algorithms;

import org.junit.Assert;

/**
 * {@see https://leetcode-cn.com/problems/container-with-most-water/}
 *
 * @author fanmo
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            max = Math.max(Math.min(height[left], height[right]) * (right - left), max);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater cw = new ContainerWithMostWater();

        Assert.assertEquals(49, cw.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
