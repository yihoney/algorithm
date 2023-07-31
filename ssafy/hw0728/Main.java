package ssafy.hw0728;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 1; i <= T; ++i) {
            int N = scanner.nextInt();
            int ans = 0;
            String[][] arr = new String[N][N];

            int j;
            int k;
            for (j = 0; j < N; ++j) {
                for (k = 0; k < N; ++k) {
                    arr[j][k] = scanner.next();
                }
            }

            for (j = 0; j < N; ++j) {
                label140: for (k = 0; k < N; ++k) {
                    int t;
                    switch (arr[j][k]) {
                        case "A":
                            t = k + 1;

                            while (true) {
                                if (t >= N || !arr[j][t].equals("S")) {
                                    continue label140;
                                }

                                ++ans;
                                ++t;
                            }
                        case "B":
                            for (t = k + 1; t < N && arr[j][t].equals("S"); ++t) {
                                ++ans;
                            }

                            for (t = k - 1; t >= 0 && arr[j][t].equals("S"); --t) {
                                ++ans;
                            }
                            break;
                        case "C":
                            for (t = k + 1; t < N && arr[j][t].equals("S"); ++t) {
                                ++ans;
                            }

                            for (t = k - 1; t >= 0 && arr[j][t].equals("S"); --t) {
                                ++ans;
                            }

                            for (t = j - 1; t >= 0 && arr[t][k].equals("S"); --t) {
                                ++ans;
                            }

                            for (t = j + 1; t < N && arr[t][k].equals("S"); ++t) {
                                ++ans;
                            }
                    }
                }
            }

            System.out.println("#" + i + " " + ans);
        }

    }
}
