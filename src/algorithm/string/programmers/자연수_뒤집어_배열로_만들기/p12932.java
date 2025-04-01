package algorithm.string.programmers.자연수_뒤집어_배열로_만들기;

public class p12932 {

    public static void main(String[] args) {
        Solution s = new Solution();
        long n = 12345;
        int[] result = s.solution(n);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}

class Solution {
    public int[] solution(long n) {
        String numStr = String.valueOf(n);
        String reversed = new StringBuilder(numStr).reverse().toString();

        int[] result = new int[reversed.length()];
        char[] charArr = reversed.toCharArray();
        for (int i = 0; i < reversed.length(); i++) {
            result[i] = charArr[i] - '0';
        }

        return result;
    }
}