import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 */
public class Leetcode76 {
    public String minWindow(String s, String t) {
        int count = -1;
        String res = "";
        for (int i = 0; i <= s.length() - t.length(); i++) {
            for (int j = i + t.length(); j <= s.length(); j++) {
                String seq = s.substring(i, j);
                boolean isMatch = true;
                // 判断t中的每一个字符是否都在seq中
                for (int index = 0; index < t.length(); index++) {
                    if (!seq.contains(t.charAt(index) + "")) {
                        isMatch = false;
                        break;
                    }
                }
                if (!isMatch) {
                    continue;
                }

                if (j - i < count || count < 0) {
                    count = j - i;
                    res = seq;
                }
            }
        }
        return res;
    }

    public String minWindow2(String s, String t) {
        Map<Character, Integer> needs = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int count = needs.getOrDefault(t.charAt(i), 0);
            needs.put(t.charAt(i), count + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int match = 0;
        int start = 0;
        int min = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c) == needs.get(c)) {
                    match++;
                }
            }
            right++;

            // window中的字符串已符合needs的要求
            while (match == needs.size()) {
                // 更新结果res
                if (right - left < min) {
                    start = left;
                    min = right - left;
                }
                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    window.put(c2, window.get(c2) - 1);
                    if (window.get(c2) < needs.get(c2)) {
                        match--;
                    }
                }
                left++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);

    }

    public static void main(String[] args) {
//        System.out.println(new Leetcode76().minWindow2("ADOBECODEBANC", "ABC"));
//         System.out.println(new Leetcode76().minWindow2("bbaa", "aba"));
         System.out.println(new Leetcode76().minWindow2("cabwefgewcwaefgcf","cae"));
    }
}
