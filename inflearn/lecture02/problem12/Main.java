package inflearn.lecture02.problem12;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(n, m, arr));
    }

    private static int solution(int n, int m, int[][] arr) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cnt = 0;
                for (int k = 0; k < m; k++) {
                    int iGrade = 0;
                    int jGrade = 0;
                    for (int s = 0; s < n; s++) {
                        if (arr[k][s] == i) {
                            iGrade = s;
                        }
                        if (arr[k][s] == j) {
                            jGrade = s;
                        }
                    }
                    if (iGrade < jGrade) {
                        cnt++;
                    }
                }
                if (cnt == m) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
