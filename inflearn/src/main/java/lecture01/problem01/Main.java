package lecture01;

import java.util.Scanner;

/**
 * @author 이하늬
 * @since 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char c = scanner.nextLine().charAt(0);
        System.out.println(solution(str, c));
    }

    private static int solution(String str, char c) {
        str = str.toUpperCase();
        c = Character.toUpperCase(c);

        int ans = 0;
        for (char strChar : str.toCharArray()) {
            if (strChar == c) {
                ans++;
            }
        }
        return ans;
    }
}