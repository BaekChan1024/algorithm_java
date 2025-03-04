package algorithm.programmers;

import java.util.Stack;

public class p43165 {

    static class State {
        int index;
        int acc;

        public State(int index, int acc) {
            this.index = index;
            this.acc = acc;
        }
    }

    public int solution(int[] numbers, int target) {

        Stack<State> stack = new Stack<>();
        stack.push(new State(0, 0));

        int count = 0;

        while(!stack.isEmpty()) {
            State state = stack.pop();

            if (state.index == numbers.length) {
                if (state.acc == target) {
                    count++;
                }
                continue;
            }

            stack.push(new State(state.index + 1, state.acc + numbers[state.index]));
            stack.push(new State(state.index + 1, state.acc - numbers[state.index]));

        }

        return count;
    }
}
