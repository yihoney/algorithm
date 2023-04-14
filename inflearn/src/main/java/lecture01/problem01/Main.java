package lecture01.problem01;

import java.util.Scanner;

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