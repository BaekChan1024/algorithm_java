package algorithm.programmers;

/*
* 문자열을 정수로 바꾸기
* */
public class p12925 {


    public static void main(String[] args) {
        String test1 = "-1234";
        System.out.println(Solution.solution(test1));
        String test2 = "1234";
        System.out.println(Solution.solution(test2));
    }

    static class Solution {
        public static int solution(String s) {
            int answer = 0;
            if (s.contains("-")) {
                answer = Integer.parseInt(s.substring(1));
                answer *= -1;
            } else {
                answer = Integer.parseInt(s);
            }
            return answer;
        }
    }

}
