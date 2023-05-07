package lecture01.problem09;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(solution(str));
        scanner.close();
    }

    private static int solution(String str) {
        String ans = "";
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                ans += c;
            }
        }
        return Integer.parseInt(ans);
    }
}