package algorithm.programmers;


import java.util.TreeMap;

public class p42628 {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (String op : operations) {
            String[] parts = op.split(" ");
            String command = parts[0];
            int num = Integer.parseInt(parts[1]);

            if (command.equals("I")) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else if (command.equals("D")) {
                if (map.isEmpty()) continue;
                if (num == 1) {
                    int maxKey = map.lastKey();
                    if (map.get(maxKey) == 1) {
                        map.remove(maxKey);
                    } else {
                        map.put(maxKey, map.get(maxKey) - 1);
                    }
                } else if (num == -1) {
                    int minKey = map.firstKey();
                    if (map.get(minKey) == 1) {
                        map.remove(minKey);
                    } else {
                        map.put(minKey, map.get(minKey) - 1);
                    }
                }
            }
        }

        if (map.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{map.lastKey(), map.firstKey()};
        }
    }

    public static void main(String[] args) {
        int[] solution = new p42628().solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
