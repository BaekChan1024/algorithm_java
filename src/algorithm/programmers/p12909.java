package algorithm.programmers;

import java.util.Stack;

public class p12909 {

    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {

            if (c == '(') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
