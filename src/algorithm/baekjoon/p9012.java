package algorithm.baekjoon;

import java.io.*;
import java.util.*;

public class p9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(),"");
            Stack<String> stack = new Stack<>();
            boolean check = false;
            while (st.hasMoreTokens()) {
                String str = st.nextToken();
                List<String> stringList = Arrays.stream(str.split("")).toList();
                for (String s : stringList) {
                    if (s.equals("(")) {
                        stack.push(str);
                    } else if (!stack.empty()) {
                        stack.pop();
                    } else {
                        System.out.println("NO");
                        check = true;
                        break;
                    }
                }

            }

            if (stack.empty() && !check) {
                System.out.println("YES");
            } else if (!check) {
                System.out.println("NO");
            }
        }
    }
}
