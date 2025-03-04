package algorithm.programmers;

import java.util.*;

public class p42586 {

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<int[]> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add(new int[]{progresses[i], speeds[i]});
        }
        int n = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int progress = poll[0];
            int speed = poll[1];
            while (progress + speed * n < 100) {
                n++;
            }
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return map.values().stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] progresses = new int[]{95, 90, 99, 99, 80, 99};
        int[] speeds = new int[]{1, 1, 1, 1, 1, 1};
        p42586 solution = new p42586();
        int[] solution1 = solution.solution(progresses, speeds);
        for (int i : solution1) {
            System.out.println(i);
        }
    }
}
