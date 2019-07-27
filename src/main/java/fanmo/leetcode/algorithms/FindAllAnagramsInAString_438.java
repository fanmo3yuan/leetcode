package fanmo.leetcode.algorithms;

import fanmo.leetcode.algorithms.util.ListUtil;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * {@see https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/}
 *
 * @author fanmo
 * @date 2019/07/27
 */
public class FindAllAnagramsInAString_438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (null == s || null == p || s.length() < p.length()) {
            return list;
        }

        int[] sCharCount = new int[26];
        int[] pCharCount = new int[26];

        for (int i = 0; i < p.length(); i++) {
            sCharCount[s.charAt(i) - 'a']++;
            pCharCount[p.charAt(i) - 'a']++;
        }

        if (check(sCharCount, pCharCount)) {
            list.add(0);
        }
        for (int i = p.length(); i < s.length(); i++) {
            sCharCount[s.charAt(i - p.length()) - 'a']--;
            sCharCount[s.charAt(i) - 'a']++;
            if (check(sCharCount, pCharCount)) {
                list.add(i - p.length() + 1);
            }
        }

        return list;
    }

    private boolean check(int[] char1Count, int[] char2Count) {
        for (int k = 0; k < 26; k++) {
            if (char1Count[k] != char2Count[k]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString_438 fas = new FindAllAnagramsInAString_438();

        Assert.assertTrue(ListUtil.listEquals(fas.findAnagrams("cbaebabacd", "abc"),
                ListUtil.list(0, 6), false));
        Assert.assertTrue(ListUtil.listEquals(fas.findAnagrams("abab", "ab"),
                ListUtil.list(0, 1, 2), false));
        Assert.assertTrue(ListUtil.listEquals(fas.findAnagrams("baa", "aa"),
                ListUtil.list(1), false));
    }

}
