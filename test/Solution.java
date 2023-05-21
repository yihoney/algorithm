import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcN = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= tcN; i++) {
            // 입력
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            // 정답 도출
            int ans = 0;

            for (int k = 0; k < n - 1; k++) {
                int tgN = arr[k];
                if (tgN > 0 && (k + tgN) < n) {
                    if (tgN + arr[k + tgN] == 0) {
                        ans++;
                    }
                }
            }

            // 출력
            sb.append("#" + i + " " + ans + "\n");
        }
        System.out.println(sb.toString());
    }
}