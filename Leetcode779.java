/**
 * 第K个语法符号
 */
public class Leetcode779 {
    public int kthGrammar(int N, int K) {
        if (N == 1) return 0;
        int ans = kthGrammar(N - 1, (K + 1) >> 1);
        if (ans == 1) {
            return K % 2 == 0 ? 0 : 1;
        } else {
            return K % 2 == 0 ? 1 : 0;
        }
    }


    public static void main(String[] args) {
        int res = new Leetcode779().kthGrammar(4, 5);
        System.out.println(res);

        System.out.println(Integer.bitCount(8-1));
    }
}
