package algorithm.programmers;

import java.util.*;

public class p49993 {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        char[] skills = skill.toCharArray();
        Map<Character, Integer> skillBook = new HashMap<>();
        for (int i = 0; i < skills.length; i++) {
            skillBook.put(skills[i], i);
        }

        for (String skillTree : skill_trees) {
            int num = -1;
            boolean flag = true;
            for (char c : skillTree.toCharArray()) {
                if (skillBook.containsKey(c)) {
                    int n = skillBook.get(c);
                    if (num + 1 == n) {
                        num = n;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = new String[]{"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(new p49993().solution(skill, skill_trees));
    }
}
