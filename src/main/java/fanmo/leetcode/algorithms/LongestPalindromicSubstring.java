package fanmo.leetcode.algorithms;


import org.junit.Assert;

/**
 * {@see https://leetcode-cn.com/problems/longest-palindromic-substring/}
 *
 * @author fanmo
 * @date 2019/04/13
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (null == s) {
            throw new IllegalArgumentException("");
        }
        if (s.length() < 1) {
            return s;
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = find(s, i, i);
            int len2 = find(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int find(String str, int start, int end) {
        int i = start;
        int j = end;

        while (i >= 0 && j < str.length() && i <= j) {
            if (str.charAt(i) != str.charAt(j)) {
                break;
            }
            i--;
            j++;
        }

        return j - i - 1;
    }


    private static void assertResult(String actual, String... expects) {
        System.out.println(actual);
        for (String expect : expects) {
            if (expect.equals(actual)) {
                return;
            }
        }
        Assert.fail();
    }

    public static void main(String[] args) {

        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();

        assertResult(lps.longestPalindrome("babad"), new String[]{"bab", "aba"});
        assertResult(lps.longestPalindrome("cbbd"), new String[]{"bb"});
        assertResult(lps.longestPalindrome("a"), new String[]{"a"});
        assertResult(lps.longestPalindrome("aaaaaaa"), new String[]{"aaaaaaa"});
        assertResult(lps.longestPalindrome("abccba"), new String[]{"abccba"});
        assertResult(lps.longestPalindrome("abcba"), new String[]{"abcba"});
        assertResult(lps.longestPalindrome("xfabaef"), new String[]{"aba"});
        assertResult(lps.longestPalindrome("xfabaeaf"), new String[]{"aba", "aea"});
        assertResult(lps.longestPalindrome("xfabaefe"), new String[]{"aba", "efe"});
        assertResult(lps.longestPalindrome("abcde"), new String[]{"a", "b", "c", "d", "e"});
        assertResult(lps.longestPalindrome(""), new String[]{""});
        assertResult(lps.longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"), new String[]{"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"});
    }


}
