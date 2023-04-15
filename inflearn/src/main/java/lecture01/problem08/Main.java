package lecture01.problem08;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(solution(str));
    }

    private static String solution(String str) {
        str = str.toUpperCase();
        String newStr = "";
        for (char c : str.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                newStr += c;
            }
        }
        System.out.println(newStr);
        int strIdxLen = newStr.length() - 1;
        for (int i = 0; i < strIdxLen / 2; i++) {
            if (newStr.charAt(i) != newStr.charAt(strIdxLen - i)) {
                return "NO";
            }
        }
        return "YES";
    }
}