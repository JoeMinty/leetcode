
/**
 * 泰波那契序列
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 */
public class Leetcode1137 {

    public static void main(String[] args) {
        int res = new Leetcode1137().tribonacciByDp(4);
        System.out.println(res);
    }

    /**
     * 递归，超时
     *
     * @param n
     * @return
     */
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

    /**
     * 递推，dp
     */
    public int tribonacciByDp(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }
        return arr[n];
    }
}
