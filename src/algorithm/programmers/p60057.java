package algorithm.programmers;

import java.util.ArrayList;
import java.util.List;

public class p60057 {

    public int solution(String s) {
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= s.length(); i++) {
            int count = compress(s, i);
            if (count < min) {
                min = count;
            }
        }

        return min;
    }

    public List<String> split(String source, int length) {
        List<String> res = new ArrayList<>();
        for (int index = 0; index < source.length(); index += length) {
            int end = index + length;
            if (end > source.length()) {
                end = source.length();
            }
            res.add(source.substring(index, end));
        }
        return res;
    }

    public int compress(String source, int length) {
        StringBuilder sb = new StringBuilder();

        String last = "";
        int count = 0;
        for (String keyword : split(source, length)) {
            if (keyword.equals(last)) {
                count++;
            } else {
                if (count > 1) {
                    sb.append(count);
                }
                sb.append(last);
                last = keyword;
                count = 1;
            }
        }

        if (count > 1) {
            sb.append(count);
        }
        sb.append(last);
        return sb.length();
    }

    public static void main(String[] args) {

    }
}
