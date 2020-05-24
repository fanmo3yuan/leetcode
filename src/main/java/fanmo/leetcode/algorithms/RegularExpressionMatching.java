package fanmo.leetcode.algorithms;

import org.junit.Assert;

/**
 * {@see https://leetcode-cn.com/problems/regular-expression-matching/}
 *
 * @author fanmo
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
//        return recursive(s, p);
        return dp(s, p);
    }

    private boolean dp(String str, String pattern) {
        if (0 == pattern.length()) {
            return 0 == str.length();
        }
        boolean[][] dp = new boolean[str.length() + 1][pattern.length() + 1];
        dp[str.length()][pattern.length()] = true;

        for (int i = str.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                boolean firstMatch = (i < str.length() && (pattern.charAt(j) == str.charAt(i) || pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || firstMatch && dp[i + 1][j];
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }


    private boolean recursive(String str, String pattern) {
        if (0 == pattern.length()) {
            return 0 == str.length();
        }
        // 第一个字符match
        boolean isFirstPosMatch = str.length() > 0 && (str.charAt(0) == pattern.charAt(0) || '.' == pattern.charAt(0));
        if (pattern.length() > 1 && pattern.charAt(1) == '*') {
            // 第一个字符match了，后面的字符是否match
            boolean useStart = isFirstPosMatch && isMatch(str.substring(1), pattern);
            // 0次匹配，直接跳过表达式
            boolean noUseStart = isMatch(str, pattern.substring(2));
            return useStart || noUseStart;
        }
        return isFirstPosMatch && isMatch(str.substring(1), pattern.substring(1));
    }


    public static void main(String[] args) {
        RegularExpressionMatching rem = new RegularExpressionMatching();
        Assert.assertFalse(rem.isMatch("ab", "a*"));
        Assert.assertTrue(rem.isMatch("a", "a"));
        Assert.assertTrue(rem.isMatch("aa", "a*"));
        Assert.assertTrue(rem.isMatch("ab", ".*"));
        Assert.assertTrue(rem.isMatch("aab", "c*a*b"));
        Assert.assertFalse(rem.isMatch("mississippi", "mis*is*p*."));
    }
}
