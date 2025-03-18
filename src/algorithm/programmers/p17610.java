package algorithm.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p17610 {

    static int[] a = new int[] {1, 9};
    static int[] s = new int[] {1, 4};
    static int[] b = new int[] {5, 9};
    int num = 0;
    // typeMap: 타입 이름 -> 각 자리별 허용 범위 배열 (예: atype -> {a,b,s,b,b})
    Map<String, int[][]> typeMap = new HashMap<>();
    List<Code> list = new ArrayList<>();

    // validation 실패 횟수 누적 변수
    int invalidCount = 0;

    static class Code {
        String type;
        String var;
        Integer number;

        public Code(String type, String var, Integer number) {
            this.type = type;
            this.var = var;
            this.number = number;
        }
    }

    // 타입 정보를 초기화합니다.
    // 예: "atype absbb" → atype의 각 자리는 'a','b','s','b','b'
    void initTypeMap(String[] types) {
        for (String type : types) {
            String[] split = type.split(" ");
            String s1 = split[1];
            char[] charArray = s1.toCharArray();
            int[][] length = new int[charArray.length][2];
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] == 'a') {
                    length[i] = a;
                }
                if (charArray[i] == 's') {
                    length[i] = s;
                }
                if (charArray[i] == 'b') {
                    length[i] = b;
                }
            }
            typeMap.put(split[0], length);
        }
    }

    /**
     * 문자열 number가 해당 타입의 각 자리 범위를 모두 만족하는지 검사합니다.
     * number의 길이가 num과 다르면 false.
     */
    public boolean validationVar(String type, String number) {
        int[][] typeRange = typeMap.get(type);
        if (number.length() != num) return false;
        for (int i = 0; i < num; i++) {
            int value = Character.getNumericValue(number.charAt(i));
            int[] range = typeRange[i];
            int min = range[0];
            int max = range[1];
            // 하나라도 범위를 벗어나면 false
            if (value < min || value > max) {
                return false;
            }
        }
        return true;
    }

    /**
     * str이 숫자로만 이루어져 있으면 그대로 반환,
     * 아니면 해당 변수명의 number를 문자열로 반환.
     */
    public String validationVarOrNumber(String str) {
        if (str.matches("\\d+")) {
            return str;
        }
        return list.stream()
                .filter(e -> e.var.equals(str))
                .findFirst()
                .get()
                .number
                .toString();
    }

    public int[] solution(int n, String[] types, String[] codes) {
        num = n;
        initTypeMap(types);

        List<Integer> answer = new ArrayList<>();

        for (String code : codes) {
            String[] strings = code.split(" ");
            String command = strings[0];

            if (command.equals("declare")) {
                // 문자열 구성: declare {타입} {변수명} {숫자}
                String type = strings[1];
                String var = strings[2];
                String value = strings[3];
                if (typeMap.containsKey(type)) {
                    invalidCount++;
                    continue;
                }
                // 중복 선언이면 invalidCount 증가
                boolean exists = list.stream().anyMatch(e -> e.var.equals(var));
                if (exists) {
                    invalidCount++;
                    continue;
                }

                // validation 실패 시, invalidCount 증가 후 무시
                if (!validationVar(type, value)) {
                    invalidCount++;
                    continue;
                }

                list.add(new Code(type, var, Integer.valueOf(value)));
            }

            if (command.equals("update")) {
                // 문자열 구성: update {변수명} {값 또는 변수명}
                String var = strings[1];
                String updateValue = validationVarOrNumber(strings[2]);

                // 업데이트할 값이 해당 변수의 타입에 부합하는지 확인
                Code target = list.stream()
                        .filter(e -> e.var.equals(var) && validationVar(e.type, updateValue))
                        .findFirst()
                        .orElse(null);

                if (target == null) {
                    invalidCount++;
                    continue;
                }
                target.number = Integer.valueOf(updateValue);
            }

            if (command.equals("print")) {
                // print 명령: print {변수명}
                Code target = list.stream()
                        .filter(e -> e.var.equals(strings[1]))
                        .findFirst()
                        .get();
                answer.add(target.number);
            }
        }
        // 마지막에 validation 실패 횟수를 결과 배열에 추가
        answer.add(invalidCount);
        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        p17610 solver = new p17610();

        int n = 5;
        String[] type = new String[]{"atype absbb", "myint aaaaa"};
        String[] code = new String[]{
                "declare atype param 75178",
                "declare atype param 19499",
                "declare atype abc 11499",
                "declare myint abc 12345",
                "print param",
                "update param 36399",
                "print param",
                "update param abc",
                "print param",
                "update abc 49356",
                "update param abc"
        };

        int[] sol = solver.solution(n, type, code);
        for (int i : sol) {
            System.out.println(i);
        }
    }
}
