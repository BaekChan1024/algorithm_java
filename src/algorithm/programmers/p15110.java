package algorithm.programmers;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class p15110 {

    public int solution(int[] ices, int t) {

        List<Integer> iceList = IntStream.of(ices).boxed().collect(Collectors.toList());
        if (iceList.isEmpty()) {
            return 0;
        }

        List<Integer> inIce = new ArrayList<>();
        List<Integer> outIce = new ArrayList<>();

        int cnt = 0;
        for (int i = 0; i < iceList.size(); i++) {
            if (cnt < iceList.stream().skip(i).mapToInt(Integer::intValue).sum()) {
                inIce.add(iceList.get(i));
                cnt += iceList.get(i);
            } else {
                outIce.add(iceList.get(i));
            }
        }

        for (int time = 1; time <= t; time++) {
            for (int i = 0; i < inIce.size(); i++) {
                inIce.set(i, inIce.get(i) - 3);
            }
            for (int i = 0; i < outIce.size(); i++) {
                outIce.set(i, outIce.get(i) - 1);
            }
            inIce.removeIf(size -> size <= 0);
            outIce.removeIf(size -> size <= 0);

            int inSum = inIce.stream().mapToInt(Integer::intValue).sum();
            int outSum = outIce.stream().mapToInt(Integer::intValue).sum();

            boolean moved;
            do {
                moved = false;
                for (int i = 0; i < inIce.size(); i++) {
                    int candidate = inIce.get(inIce.size() - 1);
                    if (inSum - candidate > outSum + candidate) {
                        inIce.remove(inIce.size() - 1);
                        outIce.add(candidate);
                        inSum -= candidate;
                        outSum += candidate;
                        moved = true;
                        break;
                    }
                }
            } while (moved);
            while (inSum < outSum && !outIce.isEmpty()) {
                int candidate = outIce.remove(0);
                inIce.add(candidate);
                inSum += candidate;
                outSum -= candidate;
            }

        }
        inIce.removeIf(size -> size < 0);
        outIce.removeIf(size -> size < 0);
        return inIce.stream().mapToInt(Integer::intValue).sum() + outIce.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        p15110 p15110 = new p15110();

        int[] ices = new int[] { 20, 5, 7, 7, 7};
        int t = 4;

        System.out.println(p15110.solution(ices, t));
    }
}
