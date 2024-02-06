package algorithm.programmers;

import java.util.*;

/*
* 약수의 합
 * */
public class p12928 {


    public static void main(String[] args) {
        int test1 = 12;
        System.out.println(Solution.solution(test1));
        int test2 = 5;
        System.out.println(Solution.solution(test2));
    }

    static class Solution {

    // 시간 복잡도가 높게 풀음
        public static int solution(int n) {
            int answer = 0;
            Set<Integer> list = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    if (i * j == n) {
                        list.add(i);
                        list.add(j);
                    }
                }
            }
            answer = list.stream().reduce(0, Integer::sum);
            return answer;
        }

        public static int bestSolution(int num) {
            int answer = 0;
            for(int i =1 ; i<=num/2;i++){
                if(num%i==0){
                    answer+=i;}}


            return answer+num;
        }
    }

}
