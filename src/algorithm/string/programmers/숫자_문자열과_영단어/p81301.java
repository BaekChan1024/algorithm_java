package algorithm.string.programmers.숫자_문자열과_영단어;

import java.util.HashMap;

public class p81301 {

    private static final HashMap<String, Integer> map = new HashMap<>(){
        {
            put("zero", 0);
            put("one", 1);
            put("two", 2);
            put("three", 3);
            put("four", 4);
            put("five", 5);
            put("six", 6);
            put("seven", 7);
            put("eight", 8);
            put("nine", 9);
        }
    };

    public int solution(String s) {
        StringBuilder strBuilder = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                strBuilder.append(c);
                continue;
            }
            sb.append(c);
            if (map.containsKey(sb.toString())) {
                strBuilder.append(map.get(sb.toString()));
                sb.setLength(0);
            }
        }
        return Integer.parseInt(strBuilder.toString());
    }

    public static void main(String[] args) {
        String s = "one4seveneight";
        System.out.println(new p81301().solution(s));
    }
}
