package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p11866 {

    public static void main(String[] args) throws IOException {
        Queue<Integer> deque = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int seq = Integer.parseInt(st.nextToken());
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i <= num; i++) {
            deque.add(i);
        }
        stringBuffer.append("<");
        while (deque.size() > 1) {
            for (int i = 0; i < seq - 1; i++) {
                Integer value = deque.poll();
                deque.offer(value);
            }
            stringBuffer.append(deque.poll());
            stringBuffer.append(", ");
        }
        stringBuffer.append(deque.poll());
        stringBuffer.append(">");
        System.out.println(stringBuffer);
    }
}
