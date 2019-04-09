package fanmo.leetcode.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * {@see https://leetcode-cn.com/problems/two-sum/}
 *
 * @author fanmo
 * @date 2019/04/07
 */
public class TowSum {

    public int[] twoSum(int[] nums, int target) {
        return foreach(nums, target);
    }

    private int[] foreach(int[] nums, int target) {
        int[] pos = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == diff) {
                    pos[0] = i;
                    pos[1] = j;
                    return pos;
                }
            }
        }
        return pos;
    }

    private int[] hash(int[] nums, int target) {
        int[] pos = new int[2];

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                pos[0] = map.get(diff);
                pos[1] = i;
                return pos;
            }
            map.put(nums[i], i);
        }

        Set<String> set = new HashSet<String>();

        return pos;
    }

    private static void print(int[] arrays) {
        if (null == arrays) {
            return;
        }
        for (int t : arrays) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TowSum towSum = new TowSum();
        int[] nums = new int[]{2, 7, 11, 5};
        int target = 9;
        print(towSum.foreach(nums, target));
        print(towSum.hash(nums, target));

        nums = new int[]{0, 7, 0, 5};
        target = 0;
        print(towSum.foreach(nums, target));
        print(towSum.hash(nums, target));

        nums = new int[]{0, -7, 0, 5};
        target = -2;
        print(towSum.foreach(nums, target));
        print(towSum.hash(nums, target));
    }

}
