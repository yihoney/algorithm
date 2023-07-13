package baekjoon.problem11659;

import java.io.*;
import java.util.*;

/**
 * @author 이하늬
 *         <pre
 *         문제 - https://www.acmicpc.net/problem/11659
 *         풀이방법
 *         1. 수를 입력 받을 때부터 prefix sum을 미리 구해 배열에 저장
 *         2.배열[종료 구간]에서 배열[시작 구간 - 1]을 빼주면 해당 구간의 합을 구함
 *         </pre>
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 콘솔에서 데이터를 입력 받기 위해 Buffer 이용
        StringTokenizer st = new StringTokenizer(br.readLine()); // 라인 단위로 입력 받아 토큰으로 나눔
        int n = Integer.parseInt(st.nextToken()); // 수의 개수
        int m = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int lt = Integer.parseInt(st.nextToken());
            int rt = Integer.parseInt(st.nextToken());
            System.out.println(arr[rt] - arr[lt - 1]);
        }
    }
}
