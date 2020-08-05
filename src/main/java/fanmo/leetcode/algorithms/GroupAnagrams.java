package fanmo.leetcode.algorithms;

import java.util.*;

/**
 * {@see https://leetcode-cn.com/problems/group-anagrams/}
 *
 * @author fanmo
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        if (null == strs || 0 == strs.length) {
            return results;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String sortedStr = Arrays.toString(ca);
            if (!map.containsKey(sortedStr)){
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
        results.addAll(map.values());
        return results;
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
    }

}
