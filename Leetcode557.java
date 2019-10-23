/**
 * 反转字符串中的单词
 */
public class Leetcode557 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String res = "";
        String[] words = s.split(" ");
        for (String word : words) {
            StringBuilder sb = new StringBuilder(word);
            res = res + sb.reverse().toString() + " ";
        }
        return res.substring(0, res.length() - 1);
    }

    public String reverseWords2(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(new StringBuilder(words[i]).reverse().toString()).append(" ");
        }

        return sb.toString().trim();
    }
}
