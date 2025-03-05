package algorithm.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class p43163 {

    static class State {
        String word;
        int step;

        public State(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }

    private boolean isConvertable(String src, String dest) {
        char[] srcCharArray = src.toCharArray();
        char[] destCharArray = dest.toCharArray();


        int diff = 0;
        for (int i = 0; i < srcCharArray.length; i++) {
            if (srcCharArray[i] != destCharArray[i]) {
                diff++;
            }
        }
        return diff == 1;
    }

    public int solution(String begin, String target, String[] words) {
        boolean[] isVisited = new boolean[words.length];

        Queue<State> queue = new LinkedList<>();

        queue.add(new State(begin, 0));
        while(!queue.isEmpty()) {
            State state = queue.poll();

            if (state.word.equals(target)) {
                return state.step;
            }

            for (int i = 0; i < words.length; i++) {
                String next = words[i];

                if (!isConvertable(state.word, next)) {
                    continue;
                }
                if (isVisited[i]) {
                    continue;
                }
                isVisited[i] = true;
                queue.add(new State(next, state.step + 1));
            }
        }

        return 0;
    }
}
