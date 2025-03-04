package algorithm.programmers;

import java.util.Arrays;

public class p12945 {

    private final int[] mem = new int[100001];
    public int solution(int n) {
        Arrays.fill(mem, -1);
        return fibonacci(n);
    }

    private int fibonacci(int n) {
        if (mem[n] != -1) {
            return mem[n];
        }
        if (n == 0 || n == 1) {
            return n;
        }
        return mem[n] =  (fibonacci(n - 1) + fibonacci(n - 2)) % 1234567;
    }
}
