package fanmo.leetcode.algorithms;

import org.junit.Assert;

/**
 * {@see https://leetcode-cn.com/problems/palindromic-substrings/}
 *
 * @author fanmo
 */
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }
//        return roughLoop(s);
        return dp(s);
    }

    private int dp(String str) {
        int len = str.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int cnt = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    if (j - i == 1 || dp[i+1][j-1]) {
                        dp[i][j] = true;
                        cnt++;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return cnt + len;
    }

    /**
     * 暴力循环
     *
     * @param str
     * @return
     */
    private int roughLoop(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            cnt++;
            for (int j = i + 1; j < str.length(); j++) {
                if (isPs(str, i, j)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean isPs(String str, int left, int right) {
        for (int i = left, j = right; i <= j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromicSubstrings ps = new PalindromicSubstrings();

        Assert.assertEquals(0, ps.countSubstrings(""));
        Assert.assertEquals(1, ps.countSubstrings("a"));
        Assert.assertEquals(3, ps.countSubstrings("abc"));
        Assert.assertEquals(6, ps.countSubstrings("aaa"));
        Assert.assertEquals(4, ps.countSubstrings("aba"));
        Assert.assertEquals(6, ps.countSubstrings("abba"));
        Assert.assertEquals(9, ps.countSubstrings("ababa"));
    }

}
