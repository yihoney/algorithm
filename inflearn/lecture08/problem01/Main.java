package inflearn.lecture08.problem01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int total = 0;
    static String ans = "NO";
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }
        DFS(0, 0, arr);
        System.out.println(ans);
    }

    private static void DFS(int level, int sum, int[] arr) {
        if (flag) {
            return;
        }
        if (sum > total / 2) {
            return;
        }
        if (level == n) {
            if ((total - sum) == sum) {
                ans = "YES";
                flag = true;
            }
        } else {
            DFS(level + 1, sum + arr[level], arr);
            DFS(level + 1, sum, arr);
        }
    }
}
