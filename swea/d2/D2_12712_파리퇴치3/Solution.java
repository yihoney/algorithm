package swea.d2.D2_12712_파리퇴치3;

import java.util.Scanner;

/**
 * @author 이하늬
 * 
 *         <pre>
 *         문제 - SWEA 12712 (파리퇴치3)
 *         풀이방법
 *         1. (0,0) 부터 (len,len) 까지 2중 for문을 돌며 + 분사 방식과 x 분사 방식으로 잡을 수 있는 파리수 구함
 *             - + 분사 방식: 기준 좌표를 기준으로 상-하-좌-우로 나눠 잡을 수 있는 파리수를 더해줌
 *             - x 분사 방식: 기준 좌표를 기준으로 사분면별로 잡을 수 있는 파리수를 더해줌
 *         2. 분사 방식 별 최대값 구해 비교하여 더 큰 값을 구함
 *         3. 기존의 최대값과 비교하여 더 크다면 ans에 저장
 *         </pre>
 */

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            System.out.println("#" + test_case + " " + solution(arr, m));
        }
        sc.close();
    }

    private static int solution(int[][] arr, int m) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int spray1 = spray1(arr, i, j, m); // + 분사
                int spray2 = spray2(arr, i, j, m); // x 분사
                // + 분사, x 분사 각 방식으로의 잡을 수 있는 최대 파리수를 비교하여 큰 값을 ans에 저장
                ans = Math.max(ans, Math.max(spray1, spray2));
            }
        }
        return ans;
    }

    private static int spray1(int[][] arr, int r, int c, int m) { // 입력 배열(파리수), 기준 행, 기준 열, 세기
        int sum = 0;
        for (int i = 1; i < m; i++) {
            // 기준 좌표의 상측
            if (r - i >= 0) {
                sum += arr[r - i][c];
            }
            // 기준 좌표의 하측
            if (r + i < arr.length) {
                sum += arr[r + i][c];
            }
            // 기준 좌표의 좌측
            if (c - i >= 0) {
                sum += arr[r][c - i];
            }
            // 기준 좌표의 우측
            if (c + i < arr.length) {
                sum += arr[r][c + i];
            }
        }
        sum += arr[r][c]; // 기준 좌표값 더해줌
        return sum;
    }

    private static int spray2(int[][] arr, int r, int c, int m) {
        int sum = 0;
        for (int i = 1; i < m; i++) {
            // 1사분면
            if (r - i >= 0 && c + i < arr.length) {
                sum += arr[r - i][c + i];
            }
            // 2사분면
            if (r - i >= 0 && c - i >= 0) {
                sum += arr[r - i][c - i];
            }
            // 3사분면
            if (r + i < arr.length && c - i >= 0) {
                sum += arr[r + i][c - i];
            }
            // 4사분면
            if (r + i < arr.length && c + i < arr.length) {
                sum += arr[r + i][c + i];
            }
        }
        sum += arr[r][c]; // 기준 좌표값 더해줌
        return sum;
    }

}