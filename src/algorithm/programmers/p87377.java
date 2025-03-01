package algorithm.programmers;
import java.util.*;
        import java.util.stream.*;

class p87377 {
    public String[] solution(int[][] line) {
        String[] answer = {};
        List<Point> list = new ArrayList<>();
        //Parsing line
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                int A = line[i][0];
                int B = line[i][1];
                int E = line[i][2];

                int C = line[j][0];
                int D = line[j][1];
                int F = line[j][2];

                list.add(Point.calculate(A, B, C, D, E, F));
            }
        }
        list = list.stream().filter(Objects::nonNull).collect(Collectors.toList());
        for (Point t : list) {
            System.out.println(t);
        }
        return answer;
    }

}

class Point {
    int x;
    int y;

    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point calculate(int A, int B, int C, int D, int E, int F) {
        int commonParrent = (A * D) - (B * C);
        if (commonParrent > 0) {
            int tx = ((B * F) - (E * D)) / commonParrent;
            int ty = ((E * C) - (A * F)) / commonParrent;

            return new Point(tx, ty);
        }

        // 평행 또는 일치할 경우 그러므로 (교점 발생 X)
        return null;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }

}