package inflearn.lecture03.problem05;

import java.io.*;

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
        for (int i = 1; i < n; i++) {
            sum += i;
            while (sum > n) {
                sum -= lt++;
            }
            if (sum == n) {
                ans++;
            }
        }
        return ans;
    }
}
