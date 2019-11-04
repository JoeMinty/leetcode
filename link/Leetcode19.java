/**
 * 删除链表中的倒数第N个节点
 */
public class Leetcode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode first = prev;
        ListNode second = prev;

        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return prev.next;
    }

}
