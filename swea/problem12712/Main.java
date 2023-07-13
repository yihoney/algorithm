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
        int spray1 = 0;
        int spray2 = 0;
        int n = arr.length;
        int startN = (n / 2 + 1) - m;
        int finishN = (n / 2 - 1) + m;
        for (int i = startN; i <= finishN; i++) {
            spray1 += arr[i][n / 2];
            spray1 += arr[n / 2][i];
            spray2 += arr[i][i];
            spray2 += arr[i][n - i - 1];
        }
        spray1 -= arr[n / 2][n / 2];
        spray2 -= arr[n / 2][n / 2];
        return Math.max(spray1, spray2);
    }
}
