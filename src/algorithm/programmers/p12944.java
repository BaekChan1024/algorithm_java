package algorithm.programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class p12944 {


    public static void main(String[] args) {
        System.out.println(Solution.solution(IntStream.of(1, 2, 3, 4).toArray()));
    }

    static class Solution {
        public static double solution(int[] arr) {
            return Arrays.stream(arr).average().orElse(0);
        }
    }
}
