package fanmo.leetcode.algorithms;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fanmo
 * @date 2019/04/15
 */
public class ZigzagConversion {

    public String convert(String s, int numRows) {
        if (null == s || numRows <= 0) {
            throw new IllegalArgumentException();
        }
        if (1 == numRows) {
            return s;
        }

        return indexNums(s, numRows);
//        return string(s, numRows);
    }

    private String indexNums(String s, int numRows) {
        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    ret.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return ret.toString();
    }

    private String string(String s, int numRows) {
        List<StringBuilder> list = new ArrayList<StringBuilder>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            list.add(new StringBuilder());
        }

        int row = 0;
        int step = 0;
        for (Character ch : s.toCharArray()) {
            list.get(row).append(ch);
            if (0 == row) {
                step = 1;
            } else if (numRows - 1 == row) {
                step = -1;
            }
            row += step;
        }

        StringBuilder str = new StringBuilder();
        for (StringBuilder sb : list) {
            str.append(sb);
        }

        return str.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion zc = new ZigzagConversion();

        /**
         *
         * LECDIHRN
         * ETOESIIG
         *
         * L   C   I   R
         * E T O E S I I G
         * E   D   H   N
         *
         * L     D     R
         * E   O E   I I
         * E C   I H   N
         * T     S     G
         *
         *
         * L        I
         * E     E  S     G
         * E   D    H   N
         * T O      I I
         * C        R
         *
         *
         * L        H
         * E      S I
         * E    I   R
         * T   E    I
         * C D      N
         * O        G
         *
         *
         *
         * 0  4     8      12
         * 1  3  5  7  9   11
         * 2     6     10
         *
         *
         * 0  10      20     2k * (row - 1)
         * 1  9   11  19     2k * (row - 1) + i,  2(k + 1) * (row - 1) - i
         * 2  8   12  18
         * 3  7   13  17
         * 4  6   14  16
         * 5      15         3k * (row - 1)
         *
         */
        Assert.assertEquals("LEETCODEISHIRING", zc.convert("LEETCODEISHIRING", 1));
        Assert.assertEquals("LECDIHRNETOESIIG", zc.convert("LEETCODEISHIRING", 2));
        Assert.assertEquals("LCIRETOESIIGEDHN", zc.convert("LEETCODEISHIRING", 3));
        Assert.assertEquals("LDREOEIIECIHNTSG", zc.convert("LEETCODEISHIRING", 4));
        Assert.assertEquals("LIEESGEDHNTOIICR", zc.convert("LEETCODEISHIRING", 5));
        Assert.assertEquals("LHESIEIRTEICDNOG", zc.convert("LEETCODEISHIRING", 6));
    }
}
