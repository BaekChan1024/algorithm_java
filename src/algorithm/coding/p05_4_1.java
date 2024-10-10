package algorithm.coding;

import java.util.Arrays;

public class p05_4_1 {

    public static int[] solution(int[] arr) {
        int[] clone = arr.clone();
        Arrays.sort(clone);
        return clone;
    }

    public static void main(String[] args) {
        int[] arr = solution(new int[]{6, 1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(arr));
    }
}
