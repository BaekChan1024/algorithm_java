package algorithm.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p42748 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int s = 0;
            List<Integer> list = new ArrayList<>();
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                list.add(array[j]);
                s = commands[i][2] - 1;
            }
            Collections.sort(list);
            answer[i] = list.get(s);
        }
        return answer;
    }
}
