package lecture01.problem02;

import java.util.Scanner;

/**
 * @author 이하늬
 * @since 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(solution(str));
    }

    public static String solution(String str) {
        String ans = "";
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                ans += Character.toLowerCase(c);
            } else {
                ans += Character.toUpperCase(c);
            }
        }
        return ans;
    }
}
