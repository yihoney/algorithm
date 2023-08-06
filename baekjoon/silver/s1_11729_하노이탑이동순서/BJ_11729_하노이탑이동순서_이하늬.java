package baekjoon.silver.s1_11729_하노이탑이동순서;

import java.io.*;

/**
 * <백준 11729 - 하노이탑이동순서>
 * 
 * - 한 번에 한 개의 원판만을 옮길 수 있음
 * - 큰 원판이 작은 원판 위에 놓이면 안됨
 * 
 * 과정 단순화
 * 1. N-1개의 원판을 시작기둥 -> 임시기둥으로 옮김
 * 2. N 원판을 시작기둥->목적기둥으로 옮김
 * 3. N-1개의 원판을 임시기둥->목적기둥으로 옮김
 * 
 * 메모리: 36884KB, 시간: 444ms
 * 
 * @author 이하늬
 */

public class BJ_11729_하노이탑이동순서_이하늬 {
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb.append((int) Math.pow(2, N) - 1).append("\n");
        recursive(N, 1, 2, 3);
        System.out.println(sb);
    }

    private static void recursive(int n, int from, int tmp, int to) {
        if (n == 0) { // 기저 조건 -> 옮길 원판 갯수가 0개라면 종료
            return;
        }

        recursive(n - 1, from, to, tmp); // N-1개의 원판을 시작기둥 -> 임시기둥으로 옮김
        sb.append(from).append(" ").append(to).append("\n"); // N 원판을 시작기둥->목적기둥으로 옮김
        recursive(n - 1, tmp, from, to); // N-1개의 원판을 임시기둥->목적기둥으로 옮김
    }
}
