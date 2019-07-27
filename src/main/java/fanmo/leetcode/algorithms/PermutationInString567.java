package fanmo.leetcode.algorithms;

import org.junit.Assert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * {@see https://leetcode-cn.com/problems/permutation-in-string/}
 *
 * @author fanmo
 * @date 2019/07/27
 */
public class PermutationInString567 {

    public boolean checkInclusion(String s1, String s2) {
        if (null == s1 || null == s2 || s1.length() > s2.length()) {
            return false;
        }

        int[] char1Count = new int[26];
        int[] char2Count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            char1Count[s1.charAt(i) - 'a']++;
            char2Count[s2.charAt(i) - 'a']++;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if (check(char1Count, char2Count)) {
                return true;
            }
            char2Count[s2.charAt(i - s1.length()) - 'a']--;
            char2Count[s2.charAt(i) - 'a']++;
        }

        return check(char1Count, char2Count);
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
        PermutationInString567 pis = new PermutationInString567();

        Assert.assertTrue(pis.checkInclusion("a", "a"));
        Assert.assertTrue(pis.checkInclusion("eidbaooo", "eidbaooo"));
        Assert.assertTrue(pis.checkInclusion("ooobadie", "eidbaooo"));
        Assert.assertTrue(pis.checkInclusion("ab", "eidbaooo"));
        Assert.assertTrue(pis.checkInclusion("ba", "eidbaooo"));
        Assert.assertTrue(pis.checkInclusion("oboadoie", "eidbaooo"));
        Assert.assertFalse(pis.checkInclusion("ba", "eidboaoo"));
        Assert.assertFalse(pis.checkInclusion("eidbaooo", "ab"));
        Assert.assertFalse(pis.checkInclusion("oboadoiei", "eidbaooo"));
        Assert.assertFalse(pis.checkInclusion("oboadoie", "eidbaoo"));
        Assert.assertFalse(pis.checkInclusion("eidbaooo", "eidbaoo"));
        Assert.assertTrue(pis.checkInclusion("ab", "afdsfdba"));
    }

}
