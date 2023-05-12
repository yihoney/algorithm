package inflearn.lecture03.problem05;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int ans = 0;
        int sum = 0;
        int lt = 1;
        int rt = 1;
        while (rt < n) {
            sum += rt;
            if (sum < n) {
                rt++;
            } else {
                if (sum == n) {
                    ans++;
                }
                sum = 0;
                lt++;
                rt = lt;
            }
        }
        return ans;
    }
}
