package inflearn.lecture05.problem07;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        System.out.println(solution(str1, str2));
    }

    private static String solution(String str1, String str2) {
        String ans = "YES";
        Queue<Character> queue = new LinkedList<>();
        for (char c : str1.toCharArray()) {
            queue.offer(c);
        }
        for (char c : str2.toCharArray()) {
            if (queue.contains(c)) {
                if (c != queue.poll()) {
                    return "NO";
                }
            }
        }
        if (!queue.isEmpty()) {
            return "NO";
        }
        return ans;
    }
}