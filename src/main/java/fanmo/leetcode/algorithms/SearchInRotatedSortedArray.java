package fanmo.leetcode.algorithms;

import org.junit.Assert;

/**
 * {@see https://leetcode-cn.com/problems/search-in-rotated-sorted-array/}
 *
 * @author fanmo
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        return find(nums, 0, nums.length - 1, target);
    }

    private int find(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray sr = new SearchInRotatedSortedArray();

        Assert.assertEquals(-1, sr.search(new int[]{4}, 0));
        Assert.assertEquals(0, sr.search(new int[]{4}, 4));
        Assert.assertEquals(-1, sr.search(new int[]{4}, 5));
        Assert.assertEquals(0, sr.search(new int[]{4, 5}, 4));
        Assert.assertEquals(1, sr.search(new int[]{4, 5}, 5));
        Assert.assertEquals(-1, sr.search(new int[]{4, 5}, 3));
        Assert.assertEquals(1, sr.search(new int[]{5, 4}, 4));
        Assert.assertEquals(-1, sr.search(new int[]{5, 4}, 6));
        Assert.assertEquals(-1, sr.search(new int[]{5, 4}, 3));
        Assert.assertEquals(4, sr.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        Assert.assertEquals(-1, sr.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        Assert.assertEquals(6, sr.search(new int[]{4, 5, 6, 7, 8, 9, 1, 2, 3}, 1));
    }
}
