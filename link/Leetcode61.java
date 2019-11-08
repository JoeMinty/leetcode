  public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int length = 0;
        ListNode second = head;
        while (second != null) {
            second = second.next;
            length++;
        }

        int len = k % length;
        if (len == 0) {
            return head;
        }

        ListNode first = head;
        second = head;

        while (len > 0) {
            len--;
            first = first.next;
        }

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        ListNode res = second.next;
        second.next = null;
        first.next = head;
       
        return res;
    }
