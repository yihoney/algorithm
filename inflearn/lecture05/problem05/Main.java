package inflearn.lecture05.problem05;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str));
    }

    private static int solution(String str) {
        int ans = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
                if (str.charAt(i - 1) == '(') {
                    ans += stack.size();
                } else {
                    ans++;
                }
            }
        }
        return ans;
    }
}