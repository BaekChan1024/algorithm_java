package algorithm.array.programmers.거리두기_확인하기;

public class p81302 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOXX"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXPX", "POOOO"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XOXOX", "PXPXP", "XOXOX", "PXPXP"}
        };

        int[] result = solution.solution(places);
        for (int res : result) {
            System.out.print(res + " ");
        }
    }
}

class Solution {

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < answer.length; i++) {
            if (checkRoom(places[i])) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }

    private boolean checkRoom(String[] place) {
        char[][] map = new char[5][5];

        for (int i = 0; i < 5; i++) {
            map[i] = place[i].toCharArray();
        }

        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if (map[y][x] == 'P') {
                    if (!isSafe(map, x, y)) return false;
                }
            }
        }
        return true;
    }

    private boolean isSafe(char[][] map, int x, int y) {
        int[][] dxdy = {
                {1,0}, {-1,0}, {0,1}, {0,-1},
                {2,0}, {-2,0}, {0,2}, {0,-2},
                {1,1}, {1,-1}, {-1,1}, {-1,-1}
        };

        for (int[] d : dxdy) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;

            int dist = Math.abs(nx - x) + Math.abs(ny - y);

            if (map[ny][nx] == 'P') {
                if (dist == 1) return false;
                if (dist == 2) {
                    if (nx == x) {
                        if (map[(ny + y) / 2][x] != 'X') return false;
                    } else if (ny == y) {
                        if (map[y][(nx + x) / 2] != 'X') return false;
                    } else {
                        if (!(map[y][nx] == 'X' && map[ny][x] == 'X')) return false;
                    }
                }
            }
        }
        return true;
    }
}

