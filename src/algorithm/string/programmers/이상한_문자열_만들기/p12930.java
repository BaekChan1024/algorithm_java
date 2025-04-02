package algorithm.string.programmers.이상한_문자열_만들기;

public class p12930 {

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "try hello world";
        System.out.println(s.solution(str));
    }
}

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(' ');
                idx = 0;
            } else {
                if (idx % 2 == 0) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                idx++;
            }
        }

        return sb.toString();
    }
}

