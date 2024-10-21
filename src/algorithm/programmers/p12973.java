package algorithm.programmers;

import java.util.Stack;

public class p12973 {

    public static int solution(String s)
    {
        Stack<Character> stk = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (!stk.isEmpty()) {
                if (stk.peek() == c) {
                    stk.pop();
                    continue;
                }
            }
            stk.push(c);
        }

        return stk.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("cdcd"));
    }
}
