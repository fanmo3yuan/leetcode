package fanmo.leetcode.algorithms;

/**
 * {@see https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/}
 *
 * @author fanmo
 */
public class RemoveNthFromEndP19 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode left = node;
        ListNode right = node;
        for (int i = 0; i <= n; i++) {
            right = right.next;
        }
        while (right != null) {
            right = right.next;
            left = left.next;
        }

        if (null == left || left.next == null) {
            return null;
        }
        left.next = left.next.next;

        return node.next;
    }

    public static void main(String[] args) {

    }
}
