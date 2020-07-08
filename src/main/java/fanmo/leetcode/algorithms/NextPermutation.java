package fanmo.leetcode.algorithms;

/**
 * {@see https://leetcode-cn.com/problems/next-permutation/}
 *
 * @author fanmo
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (null == nums || nums.length == 0) {
            return;
        }

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {
                        swap(nums, i - 1, j);
                        break;
                    }
                }
                int end = nums.length - 1 + i;
                for (int j = i; j <= end / 2; j++) {
                    swap(nums, j, end - j);
                }
                return;
            }
        }
        for (int j = 0; j <= (nums.length - 1) / 2; j++) {
            swap(nums, j, (nums.length - 1) - j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    private void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();

        np.nextPermutation(new int[]{1, 2, 3});
        np.nextPermutation(new int[]{1, 3, 2});
        np.nextPermutation(new int[]{2, 1, 3});
        np.nextPermutation(new int[]{2, 3, 1});
        np.nextPermutation(new int[]{3, 1, 2});
        np.nextPermutation(new int[]{3, 2, 1});
        np.nextPermutation(new int[]{1, 1, 5});
        np.nextPermutation(new int[]{1, 1, 1});
    }
}
