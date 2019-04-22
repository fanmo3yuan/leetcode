package fanmo.leetcode.algorithms;


import org.junit.Assert;

/**
 * {@see https://leetcode-cn.com/problems/palindrome-number/}
 *
 * @author fanmo
 * @date 2019/04/23
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        return numberJudge(x);
    }

    private boolean parseString(int x) {
        String str = String.valueOf(x);
        int length = str.length();
        for (int i = 0; i <= length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean numberJudge(int x) {
        int value = 0;
        int num = x;
        while (num > 0) {
            value = value * 10 + num % 10;
            num = num / 10;
        }

        return x == value;
    }

    public static void main(String[] args) {
        PalindromeNumber pn = new PalindromeNumber();

        Assert.assertTrue(pn.isPalindrome(0));
        Assert.assertTrue(pn.isPalindrome(1));
        Assert.assertTrue(pn.isPalindrome(11));
        Assert.assertTrue(pn.isPalindrome(121));
        Assert.assertTrue(pn.isPalindrome(1221));
        Assert.assertFalse(pn.isPalindrome(-1));
        Assert.assertFalse(pn.isPalindrome(-11));

        // ??
        Assert.assertTrue(pn.isPalindrome(-0));
    }
}
