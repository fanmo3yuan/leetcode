package fanmo.leetcode.algorithms;

import org.junit.Assert;

/**
 * {@see https://leetcode-cn.com/problems/string-to-integer-atoi/}
 *
 * @author fanmo
 * @date 2019/04/14
 */
public class StringToIntegerAtoi {

    public int myAtoi(String str) {

        if (null == str || 0 == str.length()) {
            return 0;
        }

        int start = 0;
        while (start < str.length()) {
            if (str.charAt(start) != ' ') {
                break;
            }
            start++;
        }

        if (start < str.length()) {
            if (str.charAt(start) == '-' || str.charAt(start) == '+') {
                start++;
            }
        }

        int end = start;
        while (end < str.length()) {
            if ('0' > str.charAt(end) || '9' < str.charAt(end)) {
                break;
            }
            end++;
        }
        if (start == end) {
            return 0;
        }
        if (start > 0 && '-' == str.charAt(start - 1)) {
            start--;
        }

        String res = str.substring(start, end);

        try {
            return Integer.parseInt(res);
        } catch (Exception e) {
            if (res.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }
    }

    private boolean isNumChar(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static void main(String[] args) {
        StringToIntegerAtoi sta = new StringToIntegerAtoi();

        Assert.assertEquals(123, sta.myAtoi("123"));
        Assert.assertEquals(123, sta.myAtoi("   123"));
        Assert.assertEquals(123, sta.myAtoi("+123"));
        Assert.assertEquals(123, sta.myAtoi("   +123"));
        Assert.assertEquals(-123, sta.myAtoi("-123"));
        Assert.assertEquals(-123, sta.myAtoi("   -123"));
        Assert.assertEquals(0, sta.myAtoi("--123"));
        Assert.assertEquals(123, sta.myAtoi("   0000123"));
        Assert.assertEquals(123, sta.myAtoi("123wr13 1231"));
        Assert.assertEquals(123, sta.myAtoi("   123wea1312"));
        Assert.assertEquals(123, sta.myAtoi("   123 99"));
        Assert.assertEquals(0, sta.myAtoi("   w123"));
        Assert.assertEquals(0, sta.myAtoi(""));
        Assert.assertEquals(0, sta.myAtoi(null));
        Assert.assertEquals(0, sta.myAtoi("-0"));
        Assert.assertEquals(123, sta.myAtoi("123we"));
        Assert.assertEquals(0, sta.myAtoi("w 123"));
        Assert.assertEquals(-2147483648, sta.myAtoi("-91283472332"));
        Assert.assertEquals(2147483647, sta.myAtoi("2147483648"));
        Assert.assertEquals(2147483647, sta.myAtoi("2147483647"));
        Assert.assertEquals(2147483647, sta.myAtoi("02147483647"));

    }

}
