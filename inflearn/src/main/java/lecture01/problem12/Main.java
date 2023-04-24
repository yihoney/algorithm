package lecture01.problem12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String str = scanner.next();

        Main main = new Main();
        System.out.println(main.solution(num, str));
    }

    private String solution(int num, String str) {
        String answer = "";

        for (int i = 0; i < num; i++) {
            String input = str.substring(7 * i, 7 + 7 * i);
            answer += step2and3(step1(input));
        }
        return answer;
    }

    private String step1(String str) {
        String res = "";
        for (char c : str.toCharArray()) {
            if (c == '#') {
                res += 1;
            } else {
                res += 0;
            }
        }
        return res;
    }

    private char step2and3(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(str.length() - 1 - i) == '1') {
                res += (int) Math.pow(2, i);
            }
        }
        return (char) res;
    }
}
