package algorithm.programmers;

import java.util.*;

public class p42577 {
    public boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);

        for (int i = 0; i < phoneBook.length - 1; i++)
            if (phoneBook[i + 1].startsWith(phoneBook[i]))
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new p42577().solution(new String[]{"123", "456", "789"}));
    }
}
