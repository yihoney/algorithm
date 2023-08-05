package swea.problem1961;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            System.out.println("#" + test_case);
            System.out.println(rotate(arr));

        }

        sc.close();
    }

    private static String rotate(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                sb.append(arr[j][n - i - 1]);
            }
            sb.append(" ");
            for (int k = n - 1; k >= 0; k--) {
                sb.append(arr[i][k]);
            }
            sb.append(" ");
            for (int l = 0; l < n; l++) {
                sb.append(arr[l][i]);
            }
            if (i > 0) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
