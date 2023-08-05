package string.problem8958;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String strArr[] = new String[num];
        for (int i = 0; i < num; i++) {
            strArr[i] = sc.next();
        }
        Main main = new Main();
        int[] ans = main.solution(num, strArr);
        for (int i = 0; i < num; i++) {
            System.out.println(ans[i]);
        }
        sc.close();
    }

    private int[] solution(int num, String[] strArr) {
        int[] ans = new int[num];
        int score = 0;
        int cnt = 0;
        for (int i = 0; i < num; i++) {
            for (char c : strArr[i].toCharArray()) {
                if (c == 'O') {
                    ++cnt;
                    score += cnt;
                } else {
                    cnt = 0;
                }
            }
            ans[i] = score;
            cnt = 0;
            score = 0;
        }

        return ans;
    }
}