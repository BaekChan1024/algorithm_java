package algorithm.array.programmers.교점에_별_만들기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p87377 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] line = {
            {2, -1, 4},
            {-2, -1, 4},
            {0, -1, 1},
            {5, -8, -12},
        };
        String[] result = solution.solution(line);
        for (String str : result) {
            System.out.println(str);
        }
    }
}

class Point {
    private long x;
    private long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return this.x;
    }

    public long getY() {
        return this.y;
    }

}

class PointService {
    public static Point getMax(List<Point> list) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        for (Point point : list) {
            if (x < point.getX()) {
                x = point.getX();
            }
            if (y < point.getY()) {
                y = point.getY();
            }
        }
        return new Point(x, y);
    }

    public static Point getMin(List<Point> list) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        for (Point point : list) {
            if (x > point.getX()) {
                x = point.getX();
            }
            if (y > point.getY()) {
                y = point.getY();
            }
        }
        return new Point(x, y);
    }
}

class Solution {
    public String[] solution(int[][] line) {
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                int A = line[i][0];
                int B = line[i][1];
                int E = line[i][2];
                int C = line[j][0];
                int D = line[j][1];
                int F = line[j][2];
                Point point = calculate(A, B, E, C, D, F);
                if (point != null) {
                    list.add(point);
                }
            }
        }

        Point maxPoint = PointService.getMax(list);
        Point minPoint = PointService.getMin(list);

        int width = (int) (maxPoint.getX() - minPoint.getX() + 1);
        int height = (int) (maxPoint.getY() - minPoint.getY() + 1);

        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        for (Point point : list) {
            int x = (int) (point.getX() - minPoint.getX());
            int y = (int) (maxPoint.getY() - point.getY());
            arr[y][x] = '*';
        }

        String[] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = new String(arr[i]);
        }
        return result;
    }

    public Point calculate(int A, int B, int E, int C, int D, int F) {
        long denominator = (long) A * D - (long) B * C;
        if (denominator == 0) {
            return null;
        }

        long xNumerator = (long) B * F - (long) E * D;
        long yNumerator = (long) E * C - (long) A * F;

        double x = (double) xNumerator / denominator;
        double y = (double) yNumerator / denominator;

        if (x % 1 != 0 || y % 1 != 0) {
            return null;
        }

        return new Point((long) x, (long) y);
    }
}