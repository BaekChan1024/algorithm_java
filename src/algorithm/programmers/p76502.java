package algorithm.programmers;

import java.util.*;

public class p76502 {

    public static int solution(String s) {
        int answer = 0;
        char[] charArray = s.toCharArray();
        Deque<Character> list = new ArrayDeque<>();
        for (char c : charArray) {
            list.add(c);
        }
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stk = new Stack<>();
            for (char c : list) {
                if (c == ')') {
                    if (!stk.isEmpty() && stk.peek() == '(') {
                        stk.pop();
                        continue;
                    }
                }
                if (c == '}') {
                    if (!stk.isEmpty() && stk.peek() == '{') {
                        stk.pop();
                        continue;
                    }
                }
                if (c == ']') {
                    if (!stk.isEmpty() && stk.peek() == '[') {
                        stk.pop();
                        continue;
                    }
                }
                stk.push(c);
            }
            if (stk.isEmpty()) {
                answer++;
            }
            Character pop = list.pop();
            list.addLast(pop);
        }

        return answer;
    }



    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
    }
}
