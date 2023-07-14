package swea.problem12712;

import java.util.Scanner;

public class Main {
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
        int spray1 = 0;
        int spray2 = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                spray1 = spray1(arr, i, j, m);
                spray2 = spray2(arr, i, j, m);
                ans = Math.max(ans, Math.max(spray1, spray2));
            }
        }
        return ans;
    }

    private static int spray1(int[][] arr, int r, int c, int m) {
        int sum = 0;

        for (int i = 1; i < m; i++) {
            if (r - i >= 0) {
                sum += arr[r - i][c];
            }
            if (r + i < arr.length) {
                sum += arr[r + i][c];
            }
            if (c - i >= 0) {
                sum += arr[r][c - i];
            }
            if (c + i < arr.length) {
                sum += arr[r][c + i];
            }
        }
        sum += arr[r][c];
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
        sum += arr[r][c];
        return sum;
    }

}