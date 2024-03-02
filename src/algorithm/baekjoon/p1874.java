package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int cnt = 1;
        Stack<Integer> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean c = true;
        for (int i = 0; i < num; i++) {
            boolean flag = false;
            int n = Integer.parseInt(br.readLine());
            if (cnt <= n) {
                for (int j = cnt; j <= n; j++) {
                    stk.push(cnt);
                    sb.append("+\n");
                    if (cnt == n) {
                        stk.pop();
                        sb.append("-\n");
                        flag = true;
                    }
                    cnt++;
                }
            } else {
                while (!stk.isEmpty()) {
                    Integer peek = stk.peek();
                    if (n == peek) {
                        stk.pop();
                        sb.append("-\n");
                        flag = true;
                        break;
                    }
                    stk.pop();
                    sb.append("-\n");
                }
            }
            if (!flag) {
                System.out.println("NO");
                c = false;
                break;
            }
        }
        if (c)
            System.out.println(sb);
    }
}
