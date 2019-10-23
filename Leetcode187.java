import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 重复的DNA序列
 */
public class Leetcode187 {

    // 如果字符串过长，超时
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 10) {
            return result;
        }

        for (int i = 0; i < s.length() - 10; i++) {
            String temp = s.substring(i, i + 10);
            if (!result.contains(temp) && s.substring(i + 1).contains(temp)) {
                result.add(temp);
            }
        }

        return result;
    }

    public List<String> findRepeatedDnaSequences2(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 10) {
            return res;
        }

        // 记录出现过的字符串
        Set<String> str = new HashSet<>();
        // 保存结果
        Set<String> result = new HashSet<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String seq = s.substring(i, i + 10);
            if (str.contains(seq)) {
                result.add(seq);
            } else {
                str.add(seq);
            }
        }
        res.addAll(result);
        return res;
    }

    public static void main(String[] args) {
        new Leetcode187().findRepeatedDnaSequences2("AAAAAAAAAAA");
    }
}
