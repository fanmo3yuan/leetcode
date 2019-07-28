package fanmo.leetcode.algorithms.util;

import java.util.List;

/**
 * @author fanmo
 * @date 2019/07/27
 */
public class ListUtil {

    public static <T> boolean listEquals(List<T> list1, List<T> list2, boolean seq) {
        if ((null == list1) || (null == list2)) {
            return false;
        }
        if (list1.size() != list2.size()) {
            return false;
        }
        if (!seq) {
            for (T t : list1) {
                if (!list2.contains(t)) {
                    return false;
                }
            }
            for (T t : list2) {
                if (!list1.contains(t)) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i) != list2.get(i)) {
                    return false;
                }
            }
        }
        return true;
    }

}
