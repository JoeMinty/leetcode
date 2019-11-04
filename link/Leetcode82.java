/**
 * 删除排序链表中的重复元素
 */
public class Leetcode82 {

    public ListNode deleteDuplicates(ListNode node) {
        if (node == null || node.next == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = node;
        ListNode cur = node;
        ListNode prev = dummy;

        while (cur != null) {
            ListNode tmp = cur.next;
            if (tmp.val == cur.val) {
                prev.next = tmp;
                cur = tmp;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }

        return dummy.next;
    }

}
