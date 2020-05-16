package fanmo.leetcode.algorithms;

import org.junit.Assert;

/**
 * {@see https://leetcode-cn.com/problems/valid-parentheses/}
 *
 * @author fanmo
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (null == s || s.isEmpty()) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }

        int pos = 0;
        char[] arrays = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isLeft(ch)) {
                arrays[pos++] = ch;
            } else if (isRight(ch)) {
                if (0 == pos || !isMatch(arrays[--pos], ch)) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return pos == 0;
    }

    private boolean isLeft(char ch) {
        return '(' == ch || '[' == ch || '{' == ch;
    }

    private boolean isRight(char ch) {
        return ')' == ch || ']' == ch || '}' == ch;
    }

    private boolean isMatch(char leftCh, char rightCh) {
        return ('(' == leftCh && ')' == rightCh) ||
                ('[' == leftCh && ']' == rightCh) ||
                ('{' == leftCh && '}' == rightCh);
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();

        Assert.assertTrue(vp.isValid(""));
        Assert.assertTrue(vp.isValid("{}"));
        Assert.assertTrue(vp.isValid("()"));
        Assert.assertTrue(vp.isValid("[]"));
        Assert.assertTrue(vp.isValid("[]{}"));
        Assert.assertTrue(vp.isValid("[()]{}"));
        Assert.assertTrue(vp.isValid("()[()]{}"));
        Assert.assertTrue(vp.isValid("{()[()]{}}"));
        Assert.assertTrue(vp.isValid("(((((()()()())))))"));
        Assert.assertTrue(vp.isValid("(((((())))))"));
        Assert.assertFalse(vp.isValid("{()[()]{}"));
        Assert.assertFalse(vp.isValid("{()[()]{}]"));
        Assert.assertFalse(vp.isValid("(]"));
        Assert.assertFalse(vp.isValid("(])"));
        Assert.assertFalse(vp.isValid("[(])"));
        Assert.assertFalse(vp.isValid("{}{}[(])"));
        Assert.assertFalse(vp.isValid("{("));
        Assert.assertFalse(vp.isValid("}]"));

    }

}
