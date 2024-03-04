package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p1021 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int size = Integer.parseInt(st.nextToken());
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= size; i++) {
            deque.add(i);
        }
        int num = Integer.parseInt(st.nextToken());
        StringTokenizer stSub = new StringTokenizer(br.readLine(), " ");
        int cnt = 0;
        for (int i = 0; i < num; i++) {
            int element = Integer.parseInt(stSub.nextToken());
            int index = deque.indexOf(element);
            int halfIdx;

            if (size / 2 == 0) {
                halfIdx = size / 2 - 1;
            } else {
                halfIdx = size / 2;
            }

            if (index > halfIdx) {
                while (element != deque.getFirst()) {
                    deque.addFirst(deque.removeLast());
                    cnt++;
                }
            } else {
                while (element != deque.getFirst()) {
                    deque.addLast(deque.removeFirst());
                    cnt++;
                }
            }
            deque.removeFirst();
        }
        System.out.println(cnt);
    }
}
