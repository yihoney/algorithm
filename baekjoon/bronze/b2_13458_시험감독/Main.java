package baekjoon.bronze.b2_13458_시험감독;

import java.io.*;
import java.util.*;

/**
 * @author 이하늬
 * 
 *         <pre>
 *         문제 - 백준 13458 (시험 감독)
 *         틀린 이유 - 100만개의 시험장에 100만명의 응시자가 있고, 
 *                   총감독관과 부감독관이 감시 가능한 학생 수가 1명일 경우에
 *                   필요한 감독관은 100만 * 100만이다. -> 필요한 감독관의 수는 long 타입으로 선언해야 함
 *         </pre>
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long ans = n; // 총감독은 항상 필요
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - b > 0) { // 부감독이 필요한 경우
                ans += (arr[i] - b) / c; // 총감독이 감시 가능한 응시자를 뺀 응시자들을 감시 가능한 부감독 수 구하기
                if ((arr[i] - b) % c != 0) { // 감시받지 못하는 응시자가 있을 경우
                    ans++; // 부감독 한 명 추가
                }
            }
        }
        System.out.println(ans);
    }
}
