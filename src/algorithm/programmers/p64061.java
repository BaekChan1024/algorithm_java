package algorithm.programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class p64061 {

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Stack<Integer>> stackList = new ArrayList<>();
        Stack<Integer> resultStack = new Stack<>();
        for (int i = 0; i < board.length; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = board[i].length - 1; j >= 0; j--) {
                if (board[j][i] == 0) {
                    continue;
                }
                stack.push(board[j][i]);
            }
            stackList.add(stack);
        }


        for (int move : moves) {
            Stack<Integer> integers = stackList.get(move - 1);
            if (integers.isEmpty()) {
                continue;
            }

            if (!resultStack.isEmpty() && Objects.equals(resultStack.peek(), integers.peek())) {
                resultStack.pop();
                integers.pop();
                answer += 2;
            } else {
                if (!integers.isEmpty()) {
                    resultStack.push(integers.pop());
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] ans = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] mv = {1,5,3,5,1,2,1,4};
        System.out.println(solution(ans, mv));
    }
}
