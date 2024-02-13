package algorithm.programmers;

import java.util.Arrays;

public class p12937 {

    public static void main(String[] args) {
        System.out.println(Solution.solution(3));
    }

    static class Solution {
        public static String solution(int num) {
            String answer = "";
            if (num % 2 == 0) {
                answer = "Even";
            } else {
                answer = "Odd";
            }
            return answer;
        }
    }
}
