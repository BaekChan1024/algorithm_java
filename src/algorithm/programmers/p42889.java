package algorithm.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class p42889 {

    public static int[] solution(int N, int[] stages) {
        int[] challenger = new int[N + 2];
        for (int stage : stages) {
            challenger[stage] += 1;
        }

        HashMap<Integer, Double> failed = new HashMap<>();
        int total = stages.length;
        for (int i = 1; i < N + 1; i++) {
            if (challenger[i] == 0) {
                failed.put(i, 0.0);
            } else {
                failed.put(i, (double) challenger[i] / total);
            }
            total -= challenger[i];
        }
        return failed.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(Map.Entry::getKey).toArray();
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println(Arrays.toString(solution(5, a)));
    }
}
