package fanmo.leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * {@see https://leetcode-cn.com/problems/generate-parentheses/}
 *
 * @author fanmo
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        dfs(results, "", n, n);
        return results;
    }

    private void dfs(List<String> results, String curString, int leftCount, int rightCount) {
        if (0 == leftCount && 0 == rightCount) {
            results.add(curString);
            return;
        }
        if (leftCount > rightCount) {
            // 剩余可用的左括号数大于可用右括号数肯定不合法
            return;
        }
        if (leftCount > 0) {
            dfs(results, curString + "(", leftCount - 1, rightCount);
        }
        if (rightCount > 0) {
            dfs(results, curString + ")", leftCount, rightCount - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        System.out.println(gp.generateParenthesis(1));
        System.out.println(gp.generateParenthesis(2));
        System.out.println(gp.generateParenthesis(3));
    }


}
