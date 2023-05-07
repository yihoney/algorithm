package string.problem11720;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String str = sc.next();
        System.out.println(solution(num, str));
        sc.close();
    }

    private static int solution(int num, String str) {
        String[] strArr = str.split("");
        int ans = 0;
        for (int i = 0; i < num; i++) {
            ans += Integer.parseInt(strArr[i]);
        }
        return ans;
    }
}