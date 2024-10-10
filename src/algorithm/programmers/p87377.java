package algorithm.programmers;

import java.util.*;

public class p87377 {

    public String[] solution(int[][] line) {
        List<Point> pointList = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            int x1 = line[i][0];
            int y1 = line[i][1];
            int z1 = line[i][2];
            for (int j = i + 1; j < line.length; j++) {
                int x2 = line[j][0];
                int y2 = line[j][1];
                int z2 = line[j][2];

                int x3 = (y1 * z2 - z1 * y2) / (x1 * y2 - y1 * x2);
                int y3 = (z1 * x2 - x1 * z2) / (x1 * y2 - y1 * x2);
                pointList.add(new Point(x3, y3));
            }
        }

        Point minP = getMinPoint(pointList);
        Point maxP = getMaxPoint(pointList);
        int width = maxP.getX() - minP.getX() + 1;
        int height = maxP.getY() - minP.getY() + 1;

        char[][] arr = new char[height][width];
        for (char[] chars : arr) {
            Arrays.fill(chars, '.');
        }

        for (Point p : pointList) {
            int x = p.getX() - minP.getX();
            int y = maxP.getY() - p.getY();
            arr[y][x] = '*';
        }


        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }
        return result;
    }

    private Point getMinPoint(List<Point> list) {
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;

        for (Point point : list) {
            if (x > point.x) {
                x = point.x;
            }
            if (y > point.y) {
                y = point.y;
            }
        }
        return new Point(x, y);
    }

    private Point getMaxPoint(List<Point> list) {
        int x = Integer.MIN_VALUE;
        int y = Integer.MIN_VALUE;

        for (Point point : list) {
            if (x < point.x) {
                x = point.x;
            }
            if (y < point.y) {
                y = point.y;
            }
        }
        return new Point(x, y);
    }

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) {
        p87377 p87377 = new p87377();
        int[][] test = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};

        System.out.println(p87377.solution(test));
    }
}
