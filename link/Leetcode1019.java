  public class Leetcode1019 {  
    /**
     * 效率低
     * @param head
     * @return
     */
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size() - 1; i++) {
            int num = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (num < list.get(j)) {
                    num = list.get(j);
                    break;
                }
            }
            if (num == list.get(i)) {
                res[i] = 0;
            } else {
                res[i] = num;
            }
        }
        res[list.size() - 1] = 0;
        return res;
    }

    public int[] nextLargerNodesByStack(ListNode head) {
        if (head.next == null) {
            return new int[]{0};
        }

        Stack<Integer> input = new Stack<>();
        int size = 0;
        while (head != null) {
            input.push(head.val);
            size++;
            head = head.next;
        }

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[size];

        while (!input.isEmpty()) {
            size--;
            while (!stack.isEmpty() && input.peek() >= stack.peek()) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[size] = 0;
            } else {
                result[size] = stack.peek();
            }


            stack.push(input.pop());
        }

        return result;
    }
}
