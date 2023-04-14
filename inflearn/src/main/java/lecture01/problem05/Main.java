package lecture01.problem05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(solution(str));
    }

    private static String solution(String str) {
        char[] charArr = str.toCharArray();
        int lc = 0;
        int rc = str.length() - 1;

        while (lc < rc) {
            if (!Character.isAlphabetic(charArr[lc])) {
                lc++;
            } else if (!Character.isAlphabetic(charArr[rc])) {
                rc--;
            } else {
                char tmp = charArr[lc];
                charArr[lc] = charArr[rc];
                charArr[rc] = tmp;
                lc++;
                rc--;
            }
        }
        return String.valueOf(charArr);
    }
}