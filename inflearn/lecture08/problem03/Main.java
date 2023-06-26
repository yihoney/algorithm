package inflearn.lecture08.problem03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        DFS(0, 0, 0, arr);
        System.out.println(ans);
    }

    private static void DFS(int level, int sum, int time, int[][] arr) {
        if (time > m) {
            return;
        }
        if (level == n) {
            ans = Math.max(ans, sum);
        } else {
            DFS(level + 1, sum + arr[level][0], time + arr[level][1], arr);
            DFS(level + 1, sum, time, arr);
        }
    }
}
