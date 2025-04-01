package algorithm.string.programmers.시저_암호;

public class p12926 {

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "AB";
        int n = 1;
        String result = s.solution(s1, n);
        System.out.println(result); // "BC"
    }
}

class Solution {
    public String solution(String s, int n) {
        StringBuilder b = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                c = (char) ('A' + (c - 'A' + n) % 26);
            } else if (c >= 'a' && c <= 'z') {
                c = (char) ('a' + (c - 'a' + n) % 26);
            }
            b.append(c);
        }

        return b.toString();
    }
}
