package fanmo.leetcode.algorithms;

/**
 * {@see https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/}
 *
 * @author fanmo
 */
public class RemoveDuplicatesP26 {

    public int removeDuplicates(int[] nums) {

        int p = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[++p] = nums[i];
            }
        }
        return p + 1;
    }
}
