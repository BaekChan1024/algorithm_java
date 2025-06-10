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

class Solution {
    public String[] solution(int[][] line) {
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            int[] row1 = line[i];
            int x1 = row1[0];
            int y1 = row1[1];
            int z1 = row1[2];
            for (int j = i + 1; j < line.length; j++) {
                int[] row2 = line[j];
                int x2 = row2[0];
                int y2 = row2[1];
                int z2 = row2[2];

                Point point = calculate(x1, y1, z1, x2, y2, z2);

                if (point != null) {
                    list.add(point);
                }
            }
        }

        Point maxPoint = maxPoint(list);
        Point minPoint = minPoint(list);

        int width = (int) (maxPoint.x - minPoint.x  + 1);
        int height = (int) (maxPoint.y - minPoint.y + 1);

        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        for (Point p : list) {
            int x = (int) (p.x - minPoint.x);
            int y = (int) (maxPoint.y - p.y);
            arr[y][x] = '*';
        }

        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }
        return result;
    }

    class Point {
        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    public Point maxPoint(List<Point> list) {
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;

        for (Point point : list) {
            long x0 = point.x;
            long y0 = point.y;
            if (maxX < x0) {
                maxX = x0;
            }
            if (maxY < y0) {
                maxY = y0;
            }
        }

        return new Point(maxX, maxY);
    }

    public Point minPoint(List<Point> list) {
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;

        for (Point point : list) {
            long x0 = point.x;
            long y0 = point.y;
            if (minX > x0) {
                minX = x0;
            }
            if (minY > y0) {
                minY = y0;
            }
        }

        return new Point(minX, minY);
    }

    public Point calculate(int a1, int b1, int c1, int a2, int b2, int c2) {
        long denominator = (long) a1 * b2 - (long) a2 * b1;
        if (denominator == 0) return null;

        long xNumerator = (long) b1 * c2 - (long) b2 * c1;
        long yNumerator = (long) c1 * a2 - (long) c2 * a1;

        if (xNumerator % denominator != 0 || yNumerator % denominator != 0) return null;

        long x = xNumerator / denominator;
        long y = yNumerator / denominator;

        return new Point(x, y);
    }
}