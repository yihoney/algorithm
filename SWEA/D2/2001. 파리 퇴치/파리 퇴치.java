import java.io.*;
import java.util.*;

public class Solution {
static int sumArr[][];
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            sumArr = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    sumArr[i][j] = sumArr[i][j - 1] + Integer.parseInt(st.nextToken());
                }
            }
            sb.append(String.format("#%d %d\n", tc, solution()));
        }
        System.out.println(sb);
    }

    private static int solution() {
        int MAX = Integer.MIN_VALUE;
        for (int i = 1; i + M - 1 <= N; i++) {
            int s = 0;
            for (int j = 1; j + M - 1 <= N; j++) {
                s = getBoxSum(i, j);
                MAX = Math.max(MAX, s);
            }
        }

        return MAX;
    }

    private static int getBoxSum(int startRow, int startCol) {
        int s = 0;
        for (int i = startRow; i < startRow + M; i++) {
            s += sumArr[i][startCol + M - 1] - sumArr[i][startCol - 1];
        }
        return s;
    }
}
