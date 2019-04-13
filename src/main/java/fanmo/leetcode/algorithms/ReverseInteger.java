package fanmo.leetcode.algorithms;


import org.junit.Assert;

/**
 * {@see https://leetcode-cn.com/problems/reverse-integer/}
 *
 * @author fanmo
 * @date 2019/04/13
 */
public class ReverseInteger {

    public int reverse(int x) {
        String str = String.valueOf(x);
        StringBuffer stringBuffer = new StringBuffer();
        if (x < 0) {
            str = str.substring(1);
            stringBuffer.append("-");
        }
        for (int i = str.length() - 1; i >= 0; i--) {
            stringBuffer.append(str.charAt(i));
        }
        try {
            return Integer.valueOf(stringBuffer.toString());
        } catch (Exception e) {

        }
        return 0;
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();

        Assert.assertEquals(0, ri.reverse(0));
        Assert.assertEquals(-0, ri.reverse(0));
        Assert.assertEquals(123, ri.reverse(321));
        Assert.assertEquals(-123, ri.reverse(-321));
        Assert.assertEquals(1, ri.reverse(100));
        Assert.assertEquals(-11, ri.reverse(-110));
        Assert.assertEquals(0, ri.reverse(Integer.MIN_VALUE));
    }
}
