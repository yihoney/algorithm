package ssafy.hw0728;

import java.io.*;
import java.util.*;

public class Robot01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 1; i <= tc; i++) {
            int n = Integer.parseInt(br.readLine()); // 배열의 크기

            String arr[][] = new String[n][n];
            for (int row = 0; row < n; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int col = 0; col < n; col++) {
                    arr[row][col] = st.nextToken();
                }
            }
            System.out.printf("#%d %d\n", i, solution(arr));
        }
    }

    private static int solution(String[][] arr) {
        int ans = 0;
        int len = arr.length;
        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                if (arr[row][col].equals("A")) {
                    int right = col;
                    while (++right < len && arr[row][right].equals("S")) {
                        ans++;
                    }
                } else if (arr[row][col].equals("B")) {
                    int left = col;
                    int right = col;
                    while (--left >= 0 && arr[row][left].equals("S")) {
                        ans++;
                    }
                    while (++right < len && arr[row][right].equals("S")) {
                        ans++;
                    }
                } else if (arr[row][col].equals("C")) {
                    int left = col;
                    int right = col;
                    int up = row;
                    int down = row;
                    while (--up >= 0 && arr[up][col].equals("S")) {
                        ans++;
                    }
                    while (++down < len && arr[down][col].equals("S")) {
                        ans++;
                    }

                    while (--left >= 0 && arr[row][left].equals("S")) {
                        ans++;
                    }
                    while (++right < len && arr[row][right].equals("S")) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

}
