package fanmo.leetcode.algorithms;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * {@see https://leetcode-cn.com/problems/3sum/}
 *
 * @author fanmo
 * @date 2019/06/17
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return result;
        }

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right && nums[right] >= 0) {
                int sum = nums[left] + nums[right];
                if (sum == -nums[i]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    if (!result.contains(list)) {
                        result.add(list);
                    }
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < -nums[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    private List<List<Integer>> sum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            List<int[]> find2Num = find2Num(nums, i + 1, target - nums[i]);
            if (!find2Num.isEmpty()) {
                for (int[] ints : find2Num) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(ints[0]);
                    list.add(ints[1]);
                    list.sort(Comparator.comparingInt(o -> o));
                    if (!result.contains(list)) {
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }

    private List<int[]> find2Num(int[] nums, int start, int target) {
        List<int[]> result = new ArrayList<>();
        if (start > nums.length - 2) {
            return result;
        }
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                // add
                int[] res = new int[2];
                res[0] = nums[left];
                res[1] = nums[right];
                result.add(res);
                while (left < right && nums[left] == nums[++left]) {
                }
                while (left < right && nums[right] == nums[--right]) {
                }
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    private void verify(int[] nums) {

        System.out.println("###################");

        List<List<Integer>> result = threeSum(nums);
        for (List<Integer> integers : result) {
            System.out.println(integers);
            int sum = 0;
            for (Integer integer : integers) {
                sum += integer;
            }
            Assert.assertEquals(0, sum);
        }
        System.out.println("=================");
        for (int i1 = 0; i1 < nums.length; i1++) {
            for (int i2 = i1 + 1; i2 < nums.length; i2++) {
                for (int i3 = i2 + 1; i3 < nums.length; i3++) {
                    if (nums[i1] + nums[i2] + nums[i3] == 0) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i1]);
                        list.add(nums[i2]);
                        list.add(nums[i3]);
                        list.sort(Comparator.comparingInt(o -> o));
                        System.out.println(list);
                        Assert.assertTrue(result.contains(list));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        threeSum.verify(new int[]{1, 0, -1, 0, -2, 2});
        threeSum.verify(new int[]{1, 0, -1, 0, -2, 2});
        threeSum.verify(new int[]{-3, -2, -1, 0, 0, 1, 2, 3});
        threeSum.verify(new int[]{-5, 5, 4, -3, 0, 0, 4, -2});
        threeSum.verify(new int[]{0, 0, 0, 0, 0, 0, 0, 0});
    }

}
