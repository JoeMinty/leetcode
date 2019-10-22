import java.util.ArrayList;
import java.util.List;

public class Leetcode22 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateRecursion(0, 0, n, result, "");
        return result;
    }

    public void generateRecursion(int left, int right, int n, List<String> result, String subString) {
        // 递归终止条件
        if (left == n && right == n) {
            result.add(subString);
            return;
        }

        // 处理
        if (left < n) {
            generateRecursion(left + 1, right, n, result, subString + "(");
        }

        if (right < left) {
            generateRecursion(left, right + 1, n, result, subString + ")");
        }
    }
}
