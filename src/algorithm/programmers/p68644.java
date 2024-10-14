package algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p68644 {

    public static int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                list.add(numbers[i] + numbers[j]);
            }
        }
        list.sort(Integer::compareTo);
        return list.stream().distinct().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
    }
}
