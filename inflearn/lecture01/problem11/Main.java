package lecture01.problem11;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(solution(str));
        scanner.close();
    }

    private static String solution(String str) {
        int cnt = 1;
        String ans = "";
        str += " ";

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) != str.charAt(i)) {
                ans += str.charAt(i - 1);
                if (cnt > 1) {
                    ans += String.valueOf(cnt);
                }
                cnt = 1;
            } else {
                cnt++;
            }
        }
        return ans;
    }
}
