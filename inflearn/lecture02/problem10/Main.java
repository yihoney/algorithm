package lecture02.problem10;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[num][num];
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(num, arr));
    }

    private static int solution(int num, int[][] arr) {
        int rowN[] = { -1, 0, 0, 1 };
        int colN[] = { 0, -1, 1, 0 };
        int ans = 0;
        for (int i = 0; i < num; i++) {
            boolean flag = true;
            for (int j = 0; j < num; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = rowN[k] + i;
                    int ny = colN[k] + j;
                    if (nx >= 0 && ny >= 0 && nx < num && ny < num && arr[nx][ny] >= arr[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    ans++;
                }
            }
        }
        return ans;
    }
}