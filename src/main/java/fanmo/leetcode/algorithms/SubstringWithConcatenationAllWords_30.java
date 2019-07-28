package fanmo.leetcode.algorithms;

import fanmo.leetcode.algorithms.util.ListUtil;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fanmo
 * @date 2019/07/27
 */
public class SubstringWithConcatenationAllWords_30 {

    public List<Integer> findSubstring(String source, String[] words) {
        List<Integer> list = new ArrayList<>();

        if (null == source || source.length() == 0 ||
                null == words || 0 == words.length ||
                source.length() < words.length * words[0].length()) {
            return list;
        }
        int wordSize = words[0].length();
        int length = words.length * wordSize;
        Map<String, Integer> wordsCount = new HashMap<>();
        for (String word : words) {
            wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1);
        }

        int i = 0;
        for (; i <= source.length() - length; i++) {
            if (check(source.substring(i, i + length), wordSize, wordsCount)) {
                list.add(i);
            }
        }

        return list;
    }

    private boolean check(String str, int size, Map<String, Integer> wordsCount) {
        Map<String, Integer> tmpWordsCount = new HashMap<>();
        for (int i = 0; i < str.length(); i += size) {
            String tmpStr = str.substring(i, i + size);
            if (!wordsCount.containsKey(tmpStr)) {
                return false;
            }
            tmpWordsCount.put(tmpStr, tmpWordsCount.getOrDefault(tmpStr, 0) + 1);
        }
        for (String word : wordsCount.keySet()) {
            if (!wordsCount.get(word).equals(tmpWordsCount.get(word))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SubstringWithConcatenationAllWords_30 swcaw = new SubstringWithConcatenationAllWords_30();

        Assert.assertTrue(ListUtil.listEquals(new ArrayList<>(),
                swcaw.findSubstring("", new String[]{}), false));


        Assert.assertTrue(ListUtil.listEquals(Arrays.asList(0, 9),
                swcaw.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}), false));

        Assert.assertTrue(ListUtil.listEquals(new ArrayList<>(),
                swcaw.findSubstring("wordgoodgoodgoodbestword",
                        new String[]{"word", "good", "best", "word"}), false));

        Assert.assertTrue(ListUtil.listEquals(Arrays.asList(0),
                swcaw.findSubstring("wordgoodbestword",
                        new String[]{"word", "good", "best", "word"}), false));

        Assert.assertTrue(ListUtil.listEquals(Arrays.asList(0),
                swcaw.findSubstring("wordwordgoodbest",
                        new String[]{"word", "good", "best", "word"}), false));

        Assert.assertTrue(ListUtil.listEquals(Arrays.asList(0),
                swcaw.findSubstring("wordgoodwordbest",
                        new String[]{"word", "good", "best", "word"}), false));

        Assert.assertTrue(ListUtil.listEquals(new ArrayList<>(),
                swcaw.findSubstring("wordgoodwordgoodbest",
                        new String[]{"word", "good", "best", "word"}), false));

        Assert.assertTrue(ListUtil.listEquals(new ArrayList<>(),
                swcaw.findSubstring("wordgoodbest",
                        new String[]{"word", "good", "best", "word"}), false));

        Assert.assertTrue(ListUtil.listEquals(Arrays.asList(0, 1, 2),
                swcaw.findSubstring("aaaaaab",
                        new String[]{"a", "a", "a", "a"}), false));

        Assert.assertTrue(ListUtil.listEquals(Arrays.asList(0, 1, 2),
                swcaw.findSubstring("aaaaaa",
                        new String[]{"a", "a", "a", "a"}), false));

        Assert.assertTrue(ListUtil.listEquals(Arrays.asList(0),
                swcaw.findSubstring("aaaaaaaa",
                        new String[]{"aa", "aa", "aa", "aa"}), false));

        Assert.assertTrue(ListUtil.listEquals(Arrays.asList(0, 1,2),
                swcaw.findSubstring("aaaaaaaaaa",
                        new String[]{"aa", "aa", "aa", "aa"}), false));

        Assert.assertTrue(ListUtil.listEquals(new ArrayList<>(),
                swcaw.findSubstring("aaaaa",
                        new String[]{"aa", "aa", "aaa", "aa"}), false));
    }
}
