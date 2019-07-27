package fanmo.leetcode.algorithms;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * {@see https://leetcode-cn.com/problems/4sum/}
 *
 * @author fanmo
 * @date 2019/06/17
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        for (int i1 = 0; i1 < nums.length - 3; i1++) {
            for (int i2 = i1 + 1; i2 < nums.length - 2; i2++) {
                List<int[]> subList = hash(nums, i2 + 1, target - nums[i1] - nums[i2]);
                if (subList.size() > 0) {
                    for (int[] subPos : subList) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i1]);
                        list.add(nums[i2]);
                        list.add(nums[subPos[0]]);
                        list.add(nums[subPos[1]]);
                        list.sort(Comparator.comparingInt(o -> o));
                        if (!result.contains(list)) {
                            result.add(list);
                        }
                    }

                }
            }
        }

        return result;
    }

    private List<int[]> hash(int[] nums, int start, int target) {
        List<int[]> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = start; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                int[] pos = new int[2];
                pos[0] = map.get(diff);
                pos[1] = i;
                list.add(pos);
            }
            map.put(nums[i], i);
        }

        return list;
    }

    private void verify(int[] nums, int target) {

        System.out.println("###################");

        List<List<Integer>> result = fourSum(nums, target);
        for (List<Integer> integers : result) {
            System.out.println(integers);
            int sum = 0;
            for (Integer integer : integers) {
                sum += integer;
            }
            Assert.assertEquals(target, sum);
        }
        System.out.println("=================");
        for (int i1 = 0; i1 < nums.length; i1++) {
            for (int i2 = i1 + 1; i2 < nums.length; i2++) {
                for (int i3 = i2 + 1; i3 < nums.length; i3++) {
                    for (int i4 = i3 + 1; i4 < nums.length; i4++) {
                        if (nums[i1] + nums[i2] + nums[i3] + nums[i4] == target) {
                            List<Integer> list = new ArrayList<Integer>();
                            list.add(nums[i1]);
                            list.add(nums[i2]);
                            list.add(nums[i3]);
                            list.add(nums[i4]);
                            list.sort(Comparator.comparingInt(o -> o));
                            System.out.println(list);
                            Assert.assertTrue(result.contains(list));
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        fourSum.verify(new int[]{1, 0, -1, 0, -2, 2}, 0);
        fourSum.verify(new int[]{1, 0, -1, 0, -2, 2}, 1);
        fourSum.verify(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0);
        fourSum.verify(new int[]{-5, 5, 4, -3, 0, 0, 4, -2}, 4);
    }

}
