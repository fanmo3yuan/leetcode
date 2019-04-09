package fanmo.leetcode.algorithms;

/**
 * {@see https://leetcode-cn.com/problems/add-two-numbers/}
 *
 * @author fanmo
 * @date 2019/04/08
 */
public class AddTwoNumbers {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultList = new ListNode(0);
        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode h3 = resultList;
        int mod = 0;
        while (h1 != null || h2 != null || mod != 0) {
            int v1 = (null == h1) ? 0 : h1.val;
            int v2 = (null == h2) ? 0 : h2.val;
            h3.next = new ListNode((v1 + v2 + mod) % 10);
            mod = (v1 + v2 + mod) / 10;
            h1 = (null == h1) ? null : h1.next;
            h2 = (null == h2) ? null : h2.next;
            h3 = h3.next;
        }

        return resultList.next;
    }

    private static ListNode buildListNode(int[] values) {
        ListNode head = new ListNode(values[0]);
        ListNode tail = head;
        for (int i = 1; i < values.length; i++) {
            tail.next = new ListNode(values[i]);
            tail = tail.next;
        }
        return head;
    }

    private static void print(ListNode listNode) {
        ListNode head = listNode;
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1;
        ListNode l2;

        // 342 + 465 = 807
        l1 = buildListNode(new int[]{2, 4, 3});
        l2 = buildListNode(new int[]{5, 6, 4});
        print(addTwoNumbers.addTwoNumbers(l1, l2));
        // 42 + 465 = 507
        l1 = buildListNode(new int[]{2, 4});
        l2 = buildListNode(new int[]{5, 6, 4});
        print(addTwoNumbers.addTwoNumbers(l1, l2));
        // 342 + 65 = 407
        l1 = buildListNode(new int[]{2, 4, 3});
        l2 = buildListNode(new int[]{5, 6});
        print(addTwoNumbers.addTwoNumbers(l1, l2));
        // 2 + 5 = 7
        l1 = buildListNode(new int[]{2});
        l2 = buildListNode(new int[]{5});
        print(addTwoNumbers.addTwoNumbers(l1, l2));
        // 9 + 8 = 17
        l1 = buildListNode(new int[]{9});
        l2 = buildListNode(new int[]{8});
        print(addTwoNumbers.addTwoNumbers(l1, l2));
        // 0 + 8 = 8
        l1 = buildListNode(new int[]{0});
        l2 = buildListNode(new int[]{8});
        print(addTwoNumbers.addTwoNumbers(l1, l2));
        // 0 + 0 = 0
        l1 = buildListNode(new int[]{0});
        l2 = buildListNode(new int[]{0});
        print(addTwoNumbers.addTwoNumbers(l1, l2));
        // 300 + 65 = 365
        l1 = buildListNode(new int[]{0, 0, 3});
        l2 = buildListNode(new int[]{5, 6});
        print(addTwoNumbers.addTwoNumbers(l1, l2));
        // 9999 + 999 = 10998
        l1 = buildListNode(new int[]{9, 9, 9, 9});
        l2 = buildListNode(new int[]{9, 9, 9});
        print(addTwoNumbers.addTwoNumbers(l1, l2));
        // 1234 = 1234
        l1 = buildListNode(new int[]{4, 3, 2, 1});
        print(addTwoNumbers.addTwoNumbers(l1, null));
    }

}


