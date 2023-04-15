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
        int strIdxLen = str.length() - 1;
        for (int i = 0; i < strIdxLen / 2; i++) {
            if (str.charAt(i) != str.charAt(strIdxLen - i)) {
                return "NO";
            }
        }
        return "YES";
    }
}