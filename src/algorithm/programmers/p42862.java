package algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class p42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();

        for (int l : lost) {
            lostList.add(l);
        }
        for (int r : reserve) {
            reserveList.add(r);
        }

        Iterator<Integer> it = lostList.iterator();
        while(it.hasNext()){
            int student = it.next();
            if(reserveList.contains(student)){
                it.remove();
                reserveList.remove(Integer.valueOf(student));
            }
        }

        int answer = n - lostList.size();

        for (int l : lostList) {
            if (reserveList.contains(l - 1)) {
                answer++;
                reserveList.remove(Integer.valueOf(l - 1));
            } else if (reserveList.contains(l + 1)) {
                answer++;
                reserveList.remove(Integer.valueOf(l + 1));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int solution = new p42862().solution(3, new int[]{3}, new int[]{1});
        System.out.println(solution);
    }
}
