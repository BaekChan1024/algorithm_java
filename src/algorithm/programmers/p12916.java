package algorithm.programmers;

public class p12916 {

    boolean solution(String s) {
        String lowerStr = s.toLowerCase();
        int pCnt = 0;
        int yCnt = 0;
        for (char c : lowerStr.toCharArray()) {
            if (c == 'p') {
                pCnt++;
            }
            if (c == 'y') {
                yCnt++;
            }
        }
        return pCnt == yCnt;
    }
}
