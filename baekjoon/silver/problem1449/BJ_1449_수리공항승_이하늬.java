package baekjoon.problem1449;

import java.io.*;
import java.util.*;

/**
 * @author 이하늬
 * 
 *         <pre>
 *         문제 - 백준 1449
 *         메모리 - 14280KB / 시간 - 124ms
 *         아이디어
 *         - 위치 배열을 오름차순으로 정렬한 후, 
 *          맨 앞쪽의 물이 새는 곳을 우선 막는다.
 *          (테이프가 유효한 길이는 위치 - 0.5 + 테이프의 길이) 
 *          이후엔, 다음 막아야 할 곳이 이전에 테이프로 막은 곳이 아니라면 테이프 갯수를 늘린다.
 *         </pre>
 */

public class BJ_1449_수리공항승_이하늬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(arr, l));
    }

    private static int solution(int[] arr, int l) {
        Arrays.sort(arr); // 배열 정렬

        int ans = 0;

        double tape = arr[0] - 0.5 + l; // 좌 0.5 간격을 빼주고, 테이프의 길이를 더해줌
        ans++;

        Arrays.sort(arr);

        for (int i = 1; i < arr.length; i++) {
            if (tape < arr[i] + 0.5) { // 다음 막아야 할 곳이 이전에 막은 곳의 범위를 넘어간다면
                tape = arr[i] - 0.5 + l; // 테이프가 유효한 범위를 재저장해주고
                ans++; // 테이프 갯수를 추가함
            }
        }

        return ans;
    }
}
