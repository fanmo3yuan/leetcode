package fanmo.leetcode.algorithms;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * {@see https://leetcode-cn.com/problems/longest-valid-parentheses/}
 *
 * @author fanmo
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if (null == s || s.length() < 2) {
            return 0;
        }
        int max = 0, count = 0;
        Stack<Integer> stack = new Stack<>();
        boolean[] match = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ('(' == ch) {
                stack.push(i);
            } else {
                if(stack.empty()) {
                    continue;
                }
                match[i] = true;
                match[stack.pop()] = true;
            }
        }

        for (boolean b : match) {
            if (b) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 0;
            }
        }

        return Math.max(count, max);
    }

    public static void main(String[] args) {
        LongestValidParentheses lvp = new LongestValidParentheses();

        Assert.assertEquals(0, lvp.longestValidParentheses(""));
        Assert.assertEquals(0, lvp.longestValidParentheses("("));
        Assert.assertEquals(0, lvp.longestValidParentheses(")"));
        Assert.assertEquals(2, lvp.longestValidParentheses("()"));
        Assert.assertEquals(2, lvp.longestValidParentheses("(()"));
        Assert.assertEquals(2, lvp.longestValidParentheses("())"));
        Assert.assertEquals(2, lvp.longestValidParentheses(")()"));
        Assert.assertEquals(4, lvp.longestValidParentheses("()()"));
        Assert.assertEquals(4, lvp.longestValidParentheses("(())"));
        Assert.assertEquals(4, lvp.longestValidParentheses("((())"));
        Assert.assertEquals(4, lvp.longestValidParentheses("(()))"));
        Assert.assertEquals(4, lvp.longestValidParentheses("(((())"));
        Assert.assertEquals(4, lvp.longestValidParentheses("((((((((())"));
        Assert.assertEquals(4, lvp.longestValidParentheses("(((()((((((())"));
        Assert.assertEquals(4, lvp.longestValidParentheses("(())))))))"));
        Assert.assertEquals(4, lvp.longestValidParentheses("(()))))))()"));
    }

}
