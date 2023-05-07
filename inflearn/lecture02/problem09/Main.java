package lecture02.problem09;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int arr[][] = new int[num][num];
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(num, arr));
    }

    private static int solution(int num, int[][] arr) {
        int ans = 0;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            ans = Math.max(ans, sum1);
            ans = Math.max(ans, sum2);
            sum1 = sum2 = 0;
        }
        for (int i = 0; i < num; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][num - 1 - i];
        }
        ans = Math.max(ans, sum1);
        ans = Math.max(ans, sum2);
        return ans;
    }
}
