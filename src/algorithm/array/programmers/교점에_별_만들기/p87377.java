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
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

class PointService {

    public static Point calculateMax(List<Point> list) {
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (Point point : list) {
            int x = point.getX();
            int y = point.getY();

            if (x > maxX) {
                maxX = x;
            }
            if (y > maxY) {
                maxY = y;
            }
        }
        return new Point(maxX, maxY);
    }

    public static Point calculateMin(List<Point> list) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (Point point : list) {
            int x = point.getX();
            int y = point.getY();

            if (x < minX) {
                minX = x;
            }
            if (y < minY) {
                minY = y;
            }
        }
        return new Point(minX, minY);
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
                Point p = interaction(A, B, E, C, D, F);
                if (p != null) {
                    list.add(p);
                }
            }
        }

        Point max = PointService.calculateMax(list);
        Point min = PointService.calculateMin(list);

        int width = max.getX() - min.getX() + 1;
        int height = max.getY() - min.getY() + 1;

        char[][] result = new char[height][width];
        for (char[] arr : result) {
            Arrays.fill(arr, '.');
        }

        for (Point point : list) {
            int x = point.getX() - min.getX();
            int y = max.getY() - point.getY();

            result[y][x] = '*';
        }

        String[] answer = new String[result.length];

        for (int i = 0; i < answer.length; i++) {
            String s = new String(result[i]);
            answer[i] = s;
        }

        return answer;
    }

    private Point interaction(int A, int B, int E, int C, int D, int F) {
        int denominator = A * D - B * C;

        if (denominator == 0) {
            return null;
        }

        int moleculeX = B * F - E * D;
        int moleculeY = E * C - A * F;

        double x = (double) moleculeX / denominator;
        double y = (double) moleculeY / denominator;

        if (x % 1 != 0 || y % 1 != 0) {
            return null;
        }

        return new Point( (int) x, (int) y);
    }
}