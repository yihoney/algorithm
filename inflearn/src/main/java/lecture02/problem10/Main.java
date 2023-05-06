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
            for (int j = 0; j < num; j++) {
                if (isTheBiggest(i, j, arr)) {
                    ans++;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
        return ans;
    }

    private static boolean isTheBiggest(int row, int col, int[][] arr) {
        int baseN = arr[row][col];
        if (baseN < arr[row - 1][col]) {
            return false;
        } else if (baseN < arr[row + 1][col]) {
            return false;
        } else if (baseN < arr[row][col - 1]) {
            return false;
        } else if (baseN < arr[row][col + 1]) {
            return false;
        } else {
            return true;
        }
    }
}