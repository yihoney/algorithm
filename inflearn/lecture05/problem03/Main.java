package inflearn.lecture05.problem03;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int board[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int m = Integer.parseInt(br.readLine());
        int[] move = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            move[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(board, move));
    }

    private static int solution(int[][] board, int[] move) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int col : move) {
            int num = 0;
            for (int row = 0; row < board.length; row++) {
                if (board[row][col - 1] != 0) {
                    num = board[row][col - 1];
                    board[row][col - 1] = 0;

                    if (!stack.isEmpty() && stack.peek() == num) {
                        ans += 2;
                        stack.pop();
                    } else {
                        stack.push(num);
                    }

                    break;
                }
            }
        }
        return ans;
    }
}
