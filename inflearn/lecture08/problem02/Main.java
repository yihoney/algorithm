package inflearn.lecture08.problem02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int c;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        DFS(0, 0, arr);
        System.out.println(ans);
    }

    private static void DFS(int level, int sum, int[] arr) {
        if (sum > c) {
            return;
        }
        if (level == n) {
            ans = Math.max(ans, sum);
        } else {
            DFS(level + 1, sum + arr[level], arr);
            DFS(level + 1, sum, arr);
        }
    }
}
