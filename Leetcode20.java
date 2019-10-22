import java.util.Deque;
import java.util.LinkedList;

public class Leetcode20 {
    public static void main(String[] args) {
        System.out.println(new Leetcode20().isValid("]"));
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }

            if (s.charAt(i) == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }

            if (s.charAt(i) == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }

            }

            stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }
}
