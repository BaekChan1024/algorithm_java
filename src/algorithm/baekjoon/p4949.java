package algorithm.baekjoon;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class p4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = br.readLine();
            if (s.equals(".")) {
                break;
            }
            boolean flag = true;
            List<String> collect = Arrays.stream(s.split("")).collect(Collectors.toList());
            Stack<String> stack = new Stack<>();
            for (String s1 : collect) {
                if (s1.equals("(") || s1.equals("[")) {
                    stack.push(s1);
                }
                if (s1.equals(")")) {
                    if (!stack.empty()) {
                        String peek = stack.peek();
                        if (peek.equals("(") && !stack.empty()) {
                            stack.pop();
                        } else {
                            System.out.println("no");
                            flag = false;
                            break;
                        }
                    } else {
                        System.out.println("no");
                        flag = false;
                        break;
                    }
                }
                if (s1.equals("]")) {
                    if (!stack.empty()) {
                        String peek = stack.peek();
                        if (peek.equals("[")) {
                            stack.pop();
                        } else {
                            System.out.println("no");
                            flag = false;
                            break;
                        }
                    } else {
                        System.out.println("no");
                        flag = false;
                        break;
                    }
                }
            }
            if (stack.empty() && flag) {
                System.out.println("yes");
            } else if (flag){
                System.out.println("no");
            }
        }
    }
}
