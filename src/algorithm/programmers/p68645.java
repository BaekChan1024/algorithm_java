package algorithm.programmers;

public class p68645 {

    public int[] solution(int n) {

        int[][] arr = new int[n][n];
        int num = 1;
        int x = 0;
        int y = 0;
        while (true) {
            while (true) {
                arr[y][x] = num++;
                if (y + 1 == n || arr[y + 1][x] != 0) break;
                y++;
            }
            if (x + 1 == n || arr[y][x + 1] != 0) break;
            x++;

            while (true) {
                arr[y][x] = num++;
                if (arr[y][x + 1] != 0) break;
                x++;
            }

            if (arr[y - 1][x - 1] != 0) break;
            y--;
            x--;

            while (true) {
                arr[y][x] = num++;
                if (arr[y - 1][x - 1] != 0) break;
                x--;
                y--;
            }
            if (y + 1 == n || arr[y + 1][x] != 0) break;
            y++;
        }
        int[] result = new int[num - 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                result[index] = arr[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        p68645 p68645 = new p68645();
        p68645.solution(3);
    }
}
