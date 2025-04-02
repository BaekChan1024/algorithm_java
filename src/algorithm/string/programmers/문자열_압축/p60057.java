package algorithm.string.programmers.문자열_압축;

import java.util.*;

public class p60057 {

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "aabbaccc";
        int result = s.solution(str);
        System.out.println(result); // Expected output: 7
    }
}

class Solution {
    public int solution(String s) {
        int min = Integer.MAX_VALUE;

        for (int length = 1; length <= s.length(); length++) {
            int compressNum = compress(s, length);
            if (min > compressNum) {
                min = compressNum;
            }
        }
        return min;
    }

    private int compress(String source, int length) {
        StringBuilder sb = new StringBuilder();

        String last = "";
        int count = 0;
        for (String token : split(source, length)) {
            if (token.equals(last)) {
                count++;
            } else {
                if (count > 1) {
                    sb.append(count);
                }
                sb.append(last);
                last = token;
                count = 1;
            }
        }
        if (count > 1) {
            sb.append(count);
        }
        sb.append(last);
        return sb.length();
    }

    private List<String> split(String source, int length) {
        List<String> tokens = new ArrayList<>();

        if (source == null || length <= 0) {
            return tokens;
        }

        int index = 0;

        while (index <= source.length()) {
            int end = Math.min(index + length, source.length());
            tokens.add(source.substring(index, end));
            index += length;
        }
        return tokens;
    }
}
