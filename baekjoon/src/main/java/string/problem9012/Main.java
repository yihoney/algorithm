package string.problem9012;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] strArr = new String[num];
        Main main = new Main();
        for (int i = 0; i < num; i++) {
            strArr[i] = sc.next();
        }
        for (int i = 0; i < num; i++) {
            System.out.println(main.solution(num, strArr[i]));
        }
        sc.close();
    }

    private String solution(int num, String str) {
        String ans = "";

        Stack<Character> stack = new Stack<>();
        for (int j = 0; j < str.length(); j++) {
            char c = str.charAt(j);

            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            ans = "YES";
        } else {
            ans = "NO";
        }
        return ans;
    }
}
