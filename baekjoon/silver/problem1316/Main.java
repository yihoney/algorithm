package string.problem1316;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] strArr = new String[num];
        for (int i = 0; i < num; i++) {
            strArr[i] = sc.next();
        }
        Main main = new Main();
        System.out.println(main.solution(num, strArr));
        sc.close();
    }

    private int solution(int num, String[] strArr) {
        int ans = 0;
        for (int i = 0; i < num; i++) {
            char[] arr = strArr[i].toCharArray();
            boolean flag = true;

            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] != arr[j + 1] && strArr[i].indexOf(arr[j + 1]) != j + 1) {
                    flag = false;
                }
            }

            if (flag) {
                ans++;
            }
        }
        return ans;
    }
}
