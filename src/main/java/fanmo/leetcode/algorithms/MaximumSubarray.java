package fanmo.leetcode.algorithms;

/**
 * {@see https://leetcode-cn.com/problems/maximum-subarray/}
 *
 * @author fanmo
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int sum = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }



    private int doubleLoop(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            max = Math.max(max, sum);
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
    }
}
