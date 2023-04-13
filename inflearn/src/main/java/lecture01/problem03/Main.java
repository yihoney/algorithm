package lecture01.problem03;

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

    private static String solution(String str) {
        String ans = "";
        String[] strArr = str.split(" ");

        for (String word : strArr) {
            if (ans.length() < word.length()) {
                ans = word;
            }
        }
        return ans;
    }
}
