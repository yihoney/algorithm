package inflearn.lecture03.problem04;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, m, arr));
    }

    private static int solution(int n, int m, int[] arr) {
        int ans = 0;
        int sum = 0;
        int lt = 0;
        int rt = 0;
        while (lt < n && rt < n) {
            sum += arr[rt];
            if (sum == m) {
                ans++;
            } else if (sum > m) {
                lt++;
                rt = lt;
                sum = 0;
            } else {
                rt++;
            }
        }
        return ans;
    }
}
