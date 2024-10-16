package algorithm.programmers;

import java.util.Stack;

public class p12909 {

    public static boolean solution(String s) {
        Stack<Character> stk = new Stack<>();

        for (char s1 : s.toCharArray()) {

            if (s1 == '(') {
                stk.push(s1);
            } else {
                if (stk.isEmpty()) {
                    return false;
                }
                stk.pop();
            }

        }

        return stk.isEmpty();
    }
}
