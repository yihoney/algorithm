package lecture01.problem08;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(solution(str));
        scanner.close();
    }

    private static String solution(String str) {
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String strRvs = new StringBuilder(str).reverse().toString();
        if (str.equals(strRvs)) {
            return "YES";
        }
        return "NO";
    }
}