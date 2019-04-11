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
//        return mergeFind(nums1, nums2);
        return binarySearch(nums1, nums2);
    }

    private double binarySearch(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //处理任何一个nums为空数组的情况
        if (m == 0) {
            if (n % 2 != 0) {
                return 1.0 * nums2[n / 2];
            }
            return (nums2[n / 2] + nums2[n / 2 - 1]) / 2.0;
        }
        if (n == 0) {
            if (m % 2 != 0) {
                return 1.0 * nums1[m / 2];
            }
            return (nums1[m / 2] + nums1[m / 2 - 1]) / 2.0;
        }
        int total = m + n;
        //总数为奇数，找第 total / 2 + 1 个数
        if ((total & 1) == 1) {
            return findK(total / 2 + 1, nums1, 0, nums2, 0);
        }
        //总数为偶数，找第 total / 2 个数和第total / 2 + 1个数的平均值
        return (findK(total / 2, nums1, 0, nums2, 0) +
                findK(total / 2 + 1, nums1, 0, nums2, 0)) / 2.0;
    }

    private int findK(int k, int[] nums1, int begin1, int[] nums2, int begin2) {
        if (begin1 >= nums1.length) {
            return nums2[begin2 + k - 1];
        }
        if (begin2 >= nums2.length) {
            return nums1[begin1 + k - 1];
        }
        if (1 == k) {
            return Math.min(nums1[begin1], nums2[begin2]);
        }

        int mid1 = Integer.MAX_VALUE;
        int mid2 = Integer.MAX_VALUE;
        if (begin1 + k / 2 - 1 < nums1.length) {
            mid1 = nums1[begin1 + k / 2 - 1];
        }
        if (begin2 + k / 2 - 1 < nums2.length) {
            mid2 = nums2[begin2 + k / 2 - 1];
        }

        if (mid1 < mid2) {
            return findK(k - k / 2, nums1, begin1 + k / 2, nums2, begin2);
        }

        return findK(k - k / 2, nums1, begin1, nums2, begin2 + k / 2);
    }

    // O(m+n)
    private double mergeFind(int[] nums1, int[] nums2) {
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
        num1 = new int[]{1, 3, 4, 5, 7, 8, 9, 11};
        num2 = new int[]{6, 9, 10};
        Assert.assertEquals(7.0, motsa.findMedianSortedArrays(num1, num2), 0.01);
        num1 = new int[]{1, 3, 4, 5, 7, 8, 9, 11};
        num2 = new int[]{2, 9, 10};
        Assert.assertEquals(7.0, motsa.findMedianSortedArrays(num1, num2), 0.01);
    }

}
