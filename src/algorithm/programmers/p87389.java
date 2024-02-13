package algorithm.programmers;

public class p87389 {

    public static void main(String[] args) {
        System.out.println(Solution.solution(3));
    }

    static class Solution {
        public static int solution(int n) {
            int answer = 0;
            for (int i = 1; i < n; i++) {
                if ((n % i) == 1) {
                    answer = i;
                    break;
                }
            }
            return answer;
        }
    }
}
