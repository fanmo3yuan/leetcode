package fanmo.leetcode.algorithms;

import org.junit.Assert;

/**
 * {@see https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/}
 *
 * @author fanmo
 */
public class SearchRangeP34 {
    public int[] searchRange(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                left = mid;
                right = mid;
                while (left > 0 && nums[left - 1] == nums[left]) {
                    left--;
                }
                while (right < nums.length - 1 && nums[right + 1] == nums[right]) {
                    right++;
                }
                return new int[]{left, right};
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        SearchRangeP34 sr = new SearchRangeP34();

        Assert.assertTrue(equals(new int[]{3, 4}, sr.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        Assert.assertTrue(equals(new int[]{-1, -1}, sr.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));

    }

    private static boolean equals(int[] expect, int[] actual) {
        return expect[0] == actual[0] && expect[1] == actual[1];
    }
}
