import java.util.Stack;

/**
 * 最小棧
 */
public class Leetcode155 {
    public static void main(String[] args) {

        MinStack a = new MinStack();
        a.push(2);
        a.push(0);
        a.push(3);
        a.push(0);
        System.out.println(a.getMin());
        a.pop();
        System.out.println(a.getMin());
        a.top();
        System.out.println(a.getMin());
        a.top();
        System.out.println(a.getMin());
    }

}

class MinStack {

    Stack<Integer> min = null;
    Stack<Integer> stack = null;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        min = new Stack<>();
        stack = new Stack<>();

    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty()) {
            min.push(x);
        } else {
            if (x <= min.peek()) {
                min.push(x);
            } else {
                min.push(min.peek());
            }
        }
    }

    public void pop() {

        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.pop();
    }
}
