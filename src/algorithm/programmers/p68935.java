package algorithm.programmers;

import java.util.ArrayList;
import java.util.List;

public class p68935 {

    public int solution(int n) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        int num = n;
        while(num > 0) {
            list.add(num % 3);
            num = num / 3;
        }
        double a = list.size() - 1;
        for (Integer i : list) {
            double d = (double) i;
            answer += (int) ( d * Math.pow(3, a));
            a--;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new p68935().solution(125));
    }
}
