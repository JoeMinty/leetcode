public class Leetcode6 {
    public String convert(String s, int numRows) {
        int count = s.length();
        if (numRows == 1) {
            return s;
        }
        int size = numRows * 2 - 2;
        int col = (count / size + 1) * size / 2;
        char[][] chars = new char[numRows][col];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < col; j++) {
                chars[i][j] = '#';
            }
        }

        int index = 0;
        while (index < count) {
            for (int x = 0; x < col; x++) {
                for (int y = 0; y < numRows; y++) {
                    if (index >= count) {
                        break;
                    }
                    if (x % (numRows - 1) == 0) {
                        chars[y][x] = s.charAt(index++);
                    } else {
                        if ((x + y) >= numRows - 1 && (x + y) % (numRows - 1) == 0) {
                            chars[y][x] = s.charAt(index++);
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < col; j++) {
                if (chars[i][j] != '#') {
                    sb.append(chars[i][j]);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new Leetcode6().convert("A", 1);
    }
}
