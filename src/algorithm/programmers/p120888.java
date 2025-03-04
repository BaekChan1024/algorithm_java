package algorithm.programmers;

import java.util.HashSet;
import java.util.Set;

public class p120888 {
    public String solution(String my_string) {
        StringBuilder builder = new StringBuilder();
        Set<Character> set = new HashSet<>();

        for (char c : my_string.toCharArray()) {
            if (set.contains(c)) {
                continue;
            }
            set.add(c);
            builder.append(c);
        }

        return builder.toString();
    }
}
