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
        String ans = "";

        for (int i = 0; i < num; i++) {
            String input = str.substring(0, 7).replace('#', '1').replace('*', '0');
            int res = Integer.parseInt(input, 2);
            ans += (char) res;
            str = str.substring(7);
        }
        return ans;
    }
}
