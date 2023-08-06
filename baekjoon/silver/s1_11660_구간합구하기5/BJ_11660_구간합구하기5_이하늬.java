package baekjoon.silver.s1_11660_구간합구하기5;

import java.io.*;
import java.util.*;

/**
 * 
 * @author 이하늬
 * 
 *         <pre>
 * 			- 1차원 배열의 누적합 구하던 방식을 2차원 배열에 적용시켜 해결
 * 			- (x, y)는 좌표가 아닌 (x행,y열) 의미 ㅜㅜ
 * 
 *          메모리: 115540KB, 시간: 1388ms
 *         </pre>
 * 
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 배열 크기 -> N * N
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 1][N + 1]; // 누적합을 저장하기 위해 N+1 * N+1 배열 생성
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = arr[i][j - 1] + Integer.parseInt(st.nextToken());
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int startRow = Integer.parseInt(st.nextToken()); // 시작 행 인덱스
			int startCol = Integer.parseInt(st.nextToken()); // 시작 열 인덱스
			int endRow = Integer.parseInt(st.nextToken()); // 종료 행 인덱스
			int endCol = Integer.parseInt(st.nextToken()); // 종료 열 인덱스

			int sum = 0;
			for (int row = startRow; row <= endRow; row++) { // 누적합 구할 행 반복 조건
				sum += (arr[row][endCol] - arr[row][startCol - 1]); // arr[end] - arr[start-1]을 계산하면 바로 누적합 구할 수 있음
			}
			sb.append(sum); // 구한 누적합 stringBuilder에 추가
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
