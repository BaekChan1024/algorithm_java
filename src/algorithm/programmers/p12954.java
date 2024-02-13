package algorithm.programmers;

import java.util.Arrays;

public class p12954 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.solution(-4, 2)));
    }

    static class Solution {
        public static long[] solution(int x, int n) {
            long[] answer = new long[n];
            long y = x;
            for (int i = 0; i < n; i++) {
                answer[i] = y;
                y = y + x;
            }
            return answer;
        }
    }
}
