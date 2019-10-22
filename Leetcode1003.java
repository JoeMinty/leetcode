/**
 * 检查替换后的词是否有效
 */
public class Leetcode1003 {
    public boolean isValid(String s) {
        while (s.indexOf("abc") != -1) {
            s = s.replaceAll("abc", "");
        }

        return s.equals("");
    }

    public boolean isValidByStack(String s) {
        if (s.length() < 3) {
            return false;
        }

        char[] arr = s.toCharArray();
        int[] stack = new int[s.length()];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'c') {
                if (index < 2) {
                    return false;
                } else {
                    if (stack[--index] != 'b') {
                        return false;
                    }
                    if (stack[--index] != 'a') {
                        return false;
                    }
                }
            } else {
                stack[index++] = arr[i];
            }
        }

        return index == 0;
    }

    public static void main(String[] args) {
        boolean res = new Leetcode1003().isValid("aabcbc");
        System.out.println(res);
    }
}
