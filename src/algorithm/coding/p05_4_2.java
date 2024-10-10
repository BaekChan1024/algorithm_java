package algorithm.coding;

import java.util.Arrays;
import java.util.Comparator;

public class p05_4_2 {

    public static int[] solution(int[] arr) {
        int[] clone = arr.clone();
        Integer[] array = Arrays.stream(clone).boxed().distinct().sorted(Comparator.reverseOrder()).toArray(Integer[]::new);
        return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr = solution(new int[]{6, 1, 2, 2, 3, 3, 4, 5});
        System.out.println(Arrays.toString(arr));
    }
}
