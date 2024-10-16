package algorithm.programmers;

import java.util.HashMap;
import java.util.HashSet;

public class p49994 {

    private static final HashMap<String, int[]> location = new HashMap<>();


    public static int solution(String dirs) {
        HashSet<String> answer = new HashSet<>();
        initLocation();
        int x = 5, y = 5;
        for (String s : dirs.split("")) {
            int[] move = location.get(s);
            int nx = x + move[0];
            int ny = y +  move[1];

            if (!isValidMove(nx, ny)) {
                continue;
            }
            answer.add(nx + " " + ny + " " + x + " " + y);
            answer.add(x + " " + y + " " + nx + " " + ny);

            x = nx;
            y = ny;
        }

        return answer.size() / 2;
    }

    public static void initLocation() {
        location.put("L", new int[]{-1, 0});
        location.put("R", new int[]{1, 0});
        location.put("U", new int[]{0, 1});
        location.put("D", new int[]{0, -1});
    }

    public static boolean isValidMove(int nx, int ny) {
        return 0 <= nx && nx < 11 && 0 <= ny && ny < 11;
    }

    public static void main(String[] args) {
        System.out.println(solution("LULLLLLLU"));
    }
}
