package algorithm.programmers;

import java.util.Stack;

public class p81303 {

    public static String solution(int n, int k, String[] cmd) {
        Stack<Integer> deleted = new Stack<>();

        int[] up = new int[n + 2];
        int[] down = new int[n + 2];

        for (int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }

        k++;

        return null;
    }

    public static void main(String[] args) {
        String[] list = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
        String[] list2 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
        System.out.println(solution(8, 2, list2));
    }
}
