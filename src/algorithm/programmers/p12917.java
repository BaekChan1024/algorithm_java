package algorithm.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p12917 {

    public String solution(String s) {
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }
        list.sort(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }

        return sb.toString();
    }
}
