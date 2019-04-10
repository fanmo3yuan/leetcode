package fanmo.leetcode.algorithms;

import org.junit.Assert;

/**
 * {@see https://leetcode-cn.com/problems/median-of-two-sorted-arrays/}
 *
 * @author fanmo
 * @date 2019/04/10
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return merge(nums1, nums2);
    }

    // O(m+n)
    private double merge(int[] nums1, int[] nums2) {
        int mv1 = findValueWithPos((nums1.length + nums2.length + 1) / 2, nums1, nums2);
        if ((nums1.length + nums2.length) % 2 == 0) {
            int mv2 = findValueWithPos((nums1.length + nums2.length) / 2 + 1, nums1, nums2);
            return (mv1 + mv2) / 2.0;
        }
        return mv1 + 0.0;
    }

    private int findValueWithPos(int findPos, int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
                if (findPos == i + j) {
                    return nums1[i - 1];
                }
            } else {
                j++;
                if (findPos == i + j) {
                    return nums2[j - 1];
                }
            }
        }
        while (i < nums1.length) {
            i++;
            if (findPos == i + j) {
                return nums1[i - 1];
            }
        }
        while (j < nums2.length) {
            j++;
            if (findPos == i + j) {
                return nums2[j - 1];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays motsa = new MedianOfTwoSortedArrays();
        int[] num1, num2;

        num1 = new int[]{1, 3};
        num2 = new int[]{2};
        Assert.assertEquals(2.0, motsa.findMedianSortedArrays(num1, num2), 0.01);
        num1 = new int[]{1, 2};
        num2 = new int[]{3, 4};
        Assert.assertEquals(2.5, motsa.findMedianSortedArrays(num1, num2), 0.01);
        num1 = new int[]{1, 3};
        num2 = new int[]{2, 4};
        Assert.assertEquals(2.5, motsa.findMedianSortedArrays(num1, num2), 0.01);
        num1 = new int[]{1};
        num2 = new int[]{1};
        Assert.assertEquals(1.0, motsa.findMedianSortedArrays(num1, num2), 0.01);
        num1 = new int[]{1};
        num2 = new int[]{5};
        Assert.assertEquals(3.0, motsa.findMedianSortedArrays(num1, num2), 0.01);
        num1 = new int[]{1};
        num2 = new int[]{};
        Assert.assertEquals(1.0, motsa.findMedianSortedArrays(num1, num2), 0.01);
        num1 = new int[]{1, 2, 3, 4};
        num2 = new int[]{};
        Assert.assertEquals(2.5, motsa.findMedianSortedArrays(num1, num2), 0.01);
        num1 = new int[]{1, 2, 3, 4};
        num2 = new int[]{1, 2, 3, 4};
        Assert.assertEquals(2.5, motsa.findMedianSortedArrays(num1, num2), 0.01);
        num1 = new int[]{1, 3, 4, 5, 7, 8, 9, 11};
        num2 = new int[]{1};
        Assert.assertEquals(5.0, motsa.findMedianSortedArrays(num1, num2), 0.01);
        num1 = new int[]{1, 3, 4, 5, 7, 8, 9, 11};
        num2 = new int[]{12};
        Assert.assertEquals(7.0, motsa.findMedianSortedArrays(num1, num2), 0.01);
        num1 = new int[]{1, 3, 4, 5, 7, 8, 9, 11};
        num2 = new int[]{1, 11};
        Assert.assertEquals(6.0, motsa.findMedianSortedArrays(num1, num2), 0.01);
    }

}
