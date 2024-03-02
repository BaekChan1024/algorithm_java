package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x1, y1, r1, x2, y2, r2;
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            int distance = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));


            // case 1 : 중점이 같으면서 반지름도 같을 경우
            if(x1 == x2 && y1 == y2 && r1 == r2) {
                System.out.println(-1);
            }

            // case 2-1 : 두 원의 반지름 합보다 중점간 거리가 더 길 때
            else if(distance > Math.pow(r1 + r2, 2)) {
                System.out.println(0);
            }

            // case 2-2 : 원 안에 원이 있으나 내접하지 않을 때
            else if(distance < Math.pow(r2 - r1, 2)) {
                System.out.println(0);
            }

            // case 3-1 : 내접할 때
            else if(distance == Math.pow(r2 - r1, 2)) {
                System.out.println(1);
            }


            // case 3-2 : 외접할 때
            else if(distance == Math.pow(r1 + r2, 2)) {
                System.out.println(1);
            }

            else {
                System.out.println(2);
            }
        }
    }
}
