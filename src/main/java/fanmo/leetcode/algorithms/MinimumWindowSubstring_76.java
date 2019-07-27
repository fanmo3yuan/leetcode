package fanmo.leetcode.algorithms;

import org.junit.Assert;

/**
 * {@see https://leetcode-cn.com/problems/minimum-window-substring/}
 *
 * @author fanmo
 * @date 2019/07/27
 */
public class MinimumWindowSubstring_76 {

    public String minWindow(String source, String target) {
        if (null == source || null == target || source.length() < target.length()) {
            return "";
        }
        String result = source + target;
        int[] sourceCharCount = new int[256];
        int[] targetCharCount = new int[256];
        for (int i = 0; i < target.length(); i++) {
            sourceCharCount[source.charAt(i)]++;
            targetCharCount[target.charAt(i)]++;
        }

        if (isContains(sourceCharCount, targetCharCount)) {
            return source.substring(0, target.length());
        }
        int i = 0, j = target.length();
        while (j < source.length() && i < j) {
            if (isContains(sourceCharCount, targetCharCount)) {
                String str = source.substring(i, j);
                result = result.length() < str.length() ? result : str;
                sourceCharCount[source.charAt(i++)]--;
            } else {
                sourceCharCount[source.charAt(j++)]++;
            }
        }
        while (i < j && isContains(sourceCharCount, targetCharCount)) {
            String str = source.substring(i, j);
            result = result.length() < str.length() ? result : str;
            sourceCharCount[source.charAt(i++)]--;
        }

        return result.length() > source.length() ? "" : result;
    }

    private boolean isContains(int[] sourceCharCount, int[] targetCharCount) {
        for (int i = 0; i < 256; i++) {
            if (sourceCharCount[i] < targetCharCount[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring_76 mws = new MinimumWindowSubstring_76();

        Assert.assertEquals("BANC", mws.minWindow("ADOBECODEBANC", "ABC"));
        Assert.assertEquals("ADOBEC", mws.minWindow("ADOBECODEANC", "ABC"));
        Assert.assertEquals("ADOBEC", mws.minWindow("ADOBECODEANCA", "ABC"));
        Assert.assertEquals("", mws.minWindow("DOBECODEBNC", "ABC"));
        Assert.assertEquals("BAC", mws.minWindow("DOBECODEBAC", "ABC"));
        Assert.assertEquals("BAC", mws.minWindow("DOBECODEBAC", "ABC"));
        Assert.assertEquals("BAC", mws.minWindow("BACECODEAB", "ABC"));

    }
}
