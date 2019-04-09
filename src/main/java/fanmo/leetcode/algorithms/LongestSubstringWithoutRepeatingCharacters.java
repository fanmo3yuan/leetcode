package fanmo.leetcode.algorithms;

import com.sun.tools.javac.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * {@see https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/}
 *
 * @author fanmo
 * @date 2019/04/09
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }
        int max = 0;
        int[] chPos = new int[128];
        int start = 0;
        int end = 0;
        for (; end < s.length(); end++) {
            start = Math.max(start, chPos[s.charAt(end)]);
            max = Math.max(end - start + 1, max);
            chPos[s.charAt(end)] = end + 1;
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();

        Assert.check(0 == lswrc.lengthOfLongestSubstring(null));
        Assert.check(0 == lswrc.lengthOfLongestSubstring(""));
        Assert.check(1 == lswrc.lengthOfLongestSubstring("a"));
        Assert.check(1 == lswrc.lengthOfLongestSubstring("aaaaaaa"));
        Assert.check(5 == lswrc.lengthOfLongestSubstring("abcde"));
        Assert.check(5 == lswrc.lengthOfLongestSubstring("abcdeabcde"));
        Assert.check(5 == lswrc.lengthOfLongestSubstring("abcdeabc"));
        Assert.check(5 == lswrc.lengthOfLongestSubstring("abceabcde"));
        Assert.check(5 == lswrc.lengthOfLongestSubstring("ababcdeb"));
        Assert.check(3 == lswrc.lengthOfLongestSubstring("abcabcbb"));
        Assert.check(4 == lswrc.lengthOfLongestSubstring("abbcdec"));
        Assert.check(3 == lswrc.lengthOfLongestSubstring("pwwkew"));
    }

}
