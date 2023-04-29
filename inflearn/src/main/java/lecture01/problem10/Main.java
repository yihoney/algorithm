package lecture01.problem10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char target = scanner.next().charAt(0);
        for (int num : solution(str, target)) {
            System.out.print(num + " ");
        }
        scanner.close();
    }

    private static int[] solution(String str, char c) {
        int[] answer = new int[str.length()];
        int minDis = 100;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != c) {
                answer[i] = ++minDis;
            } else {
                minDis = 0;
            }
        }

        minDis = 100;

        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) != c) {
                answer[i] = Math.min(answer[i], ++minDis);
            } else {
                minDis = 0;
            }
        }

        return answer;
    }
}
