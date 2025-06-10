package algorithm.string.programmers.신규_아이디_추천;

public class p72410 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] new_id = {"...!@BaT#*..y.abcdefghijklm",
                           "z-+.^." ,
                           "=.=",
                           "123_.def",
                           "abcdefghijklmn.p" };

        for (String id : new_id) {
            System.out.println("Input: " + id);
            String result = solution.solution(id);
            System.out.println("Output: " + result);
        }
    }
}

class Solution {
    public String solution(String new_id) {
        String str = new_id.toLowerCase();
        str = str.replaceAll("[^a-z0-9\\-_.]", "");
        str = str.replaceAll("\\.+", ".");
        str = str.replaceAll("^\\.+|\\.+$", "");
        if (str.isEmpty()) {
            str = "a";
        }
        if (str.length() >= 16) {
            str = str.substring(0, 15);
            str = str.replaceAll("\\.+$", "");
        }
        while (str.length() < 3) {
            str += str.charAt(str.length() - 1);
        }
        return str;
    }
}
