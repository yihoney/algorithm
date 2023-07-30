package baekjoon.problem11399;

import java.io.*;
import java.util.*;

/**
 * @author 이하늬
 * 
 *         <pre>
 *         문제 - 백준 11399
 *         메모리 - 14436KB / 시간 - 132ms
 *         아이디어
 *         - 시간의 합의 최솟값을 구하기 위해선 대기시간을 줄여야한다. 따라서,
 *          1. 배열을 오름차순으로 정렬한 후
 *          2. 배열의 누적합을 구한다.
 *         </pre>
 */

public class BJ_11399_ATM_이하늬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(arr));
    }

    private static int solution(int[] arr) {
        Arrays.sort(arr); // 배열 정렬
        int ans = arr[0]; // 배열의 첫번째 값을 초깃값으로 설정

        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1]; // 이전 누적값을 현재 인덱스의 값과 더해 저장
            ans += arr[i]; // 저장된 값을 기존의 값에 더해줌
        }
        return ans;
    }
}
