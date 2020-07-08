package fanmo.leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * {@see https://leetcode-cn.com/problems/combination-sum/}
 *
 * @author fanmo
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        bfs2(results, new ArrayList<>(), candidates, 0, target);
        return results;
    }

    // https://leetcode-cn.com/problems/combination-sum
    private void bfs(List<List<Integer>> results, List<Integer> result, int[] candidates, int start, int target) {
        if (0 == target) {
            System.out.println(result);
            results.add(new ArrayList<>(result));
            return;
        }
        if (0 > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                result.add(candidates[i]);
                bfs(results, result, candidates, i, target - candidates[i]);
                result.remove(result.size() - 1);
            }
        }
    }

    // https://leetcode-cn.com/problems/combination-sum-ii/
    private void bfs2(List<List<Integer>> results, List<Integer> result, int[] candidates, int start, int target) {
        if (0 == target) {
            results.add(new ArrayList<>(result));
            return;
        }
        if (0 > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] <= target) {
                result.add(candidates[i]);
                bfs2(results, result, candidates, i + 1, target - candidates[i]);
                result.remove(result.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();

        cs.combinationSum(new int[]{2, 3, 6, 7}, 7);
        cs.combinationSum(new int[]{2, 3, 5}, 8);
        cs.combinationSum(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        cs.combinationSum(new int[]{2, 5, 2, 1, 2}, 5);
        cs.combinationSum(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);

    }
}
