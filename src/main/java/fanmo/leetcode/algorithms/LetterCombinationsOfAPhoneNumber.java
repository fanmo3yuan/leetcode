package fanmo.leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * {@see https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/}
 *
 * @author fanmo
 */
public class LetterCombinationsOfAPhoneNumber {

    private String[] numberMap = new String[]{
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (null != digits && !digits.isEmpty()) {
            dfs(results, "", digits, 0);
        }
        return results;
    }

    private void dfs(List<String> results, String curString, String digits, int pos) {
        if (pos == digits.length() - 1) {
            int v = digits.charAt(pos) - '0';
            if (v > 1 && v < 10) {
                for (int i = 0; i < numberMap[v].length(); i++) {
                    results.add(curString + (numberMap[v].charAt(i)));
                }
            }
            return;
        }
        int v = digits.charAt(pos) - '0';
        for (int i = 0; i < numberMap[v].length(); i++) {
            if (v > 1 && v < 10) {
                dfs(results, curString + (numberMap[v].charAt(i)), digits, pos + 1);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber lp = new LetterCombinationsOfAPhoneNumber();
        System.out.println(lp.letterCombinations("2"));
        System.out.println(lp.letterCombinations("23"));
        System.out.println(lp.letterCombinations("9"));
        System.out.println(lp.letterCombinations(""));
    }

}
