package algorithm.array.programmers.삼각_달팽이;

public class p68645 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int[] result = solution.solution(n);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}


class Solution {
    public int[] solution(int n) {
        int[][] map = new int[n][n];
        int[] dx = {0, 1, -1};
        int[] dy = {1, 0, -1};

        int x = 0;
        int y = 0;
        int dir = 0;
        int cnt = 1;
        int max = n * (n + 1) / 2;

        while (cnt <= max) {
            map[y][x] = cnt++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[ny][nx] != 0) {
                dir = (dir + 1) % 3;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;
        }

        int[] result = new int[max];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[idx] = map[i][j];
                idx++;
            }
        }
        return result;
    }
}
