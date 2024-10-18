package algorithm.coding;

import java.util.Stack;

public class p06_3_2 {

    public static String solution(int num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(num % 2);
            num = num / 2;
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(1234567890));
    }
}
