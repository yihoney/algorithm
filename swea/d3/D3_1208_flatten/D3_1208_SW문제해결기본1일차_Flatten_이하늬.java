package swea.D3.D3_1208_flatten;

import java.io.*;
import java.util.*;

/**
 * @author 이하늬
 * 
 *         <pre>
 *         문제 - SWEA 1208 flatten
 *         아이디어
 *         - 정렬 후 맨 첫번째 값 (최저점)은 +1을, 맨 마지막 값 (최고점)은 -1을 해줌
 *         - 두 값의 차이를 빌더에 추가
 * 
 *         - 메모리: 22,648KB, 시간: 131ms
 *         </pre>
 */

public class D3_1208_SW문제해결기본1일차_Flatten_이하늬 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[100];
        for (int tc = 1; tc <= 10; tc++) {
            int dumpN = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            solution(tc, arr, dumpN, 0);
        }
        System.out.println(sb);
    }

    private static void solution(int tc, int[] arr, int dumpN, int cnt) {

        if (dumpN == cnt) { // 탈출 조건
            sb.append(String.format("#%d ", tc));
            Arrays.sort(arr); // 차를 구하기 전 다시 한 번 정렬
            sb.append(arr[99] - arr[0]);
            sb.append("\n");
            return;
        }

        Arrays.sort(arr); // 정렬

        // dump 수행
        arr[0]++; // 최저점: 기존 갯수 + 1
        arr[99]--; // 최고점: 기존 갯수 - 1

        solution(tc, arr, dumpN, cnt + 1);

    }
}
