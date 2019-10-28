/**
 * 两数相加
 */
public class Leetcode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 进位符
        int flag = 0;
        int num1 = 0;
        int num2 = 0;
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }

            int result = num1 + num2 + flag;
            node.next = new ListNode(result % 10);
            flag = result / 10;
            num1 = 0;
            num2 = 0;
            node = node.next;
        }

        if (flag > 0) {
            node.next = new ListNode(flag);
        }
        return dummy.next;
    }
}
