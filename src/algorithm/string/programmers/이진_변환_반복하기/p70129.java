package algorithm.string.programmers.이진_변환_반복하기;

import java.util.Arrays;

public class p70129 {

    public static int[] solution(String s) {
        int translateCount = 0;
        int totalZeroCount = 0;
        int value = 0;
        while (value != 1) {
            int zeroCount = 0;
            int oneCount = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
            totalZeroCount += zeroCount;
            value = oneCount;
            s = translateBinary(oneCount);
            translateCount++;
        }
        return new int[]{translateCount, totalZeroCount};
    }

    public static String translateBinary(int count) {

        StringBuilder sb = new StringBuilder();
        while (count > 0) {
            sb.append(count % 2);
            count /= 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "1111111";
        System.out.println(Arrays.toString(solution(s)));
    }
}
