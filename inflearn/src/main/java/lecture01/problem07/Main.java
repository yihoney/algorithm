package lecture01.problem07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(solution(str));
    }

    private static String solution(String str) {
        str = str.toUpperCase();
        int idx = str.length() / 2 - 1;
        while (idx >= 0) {
            if (str.charAt(idx) == str.charAt(str.length() - 1 - idx)) {
                idx--;
            } else {
                return "NO";
            }
        }
        return "YES";
    }
}