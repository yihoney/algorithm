import java.io.*;
import java.util.*;

/**
 * BJ 1026 보물
 * 
 * 함수 S = A[0] × B[0] + ... + A[N-1] × B[N-1] S의 값을 가장 작게 만들기 위해 A의 수를 재배열 (B에
 * 있는 수는 재배열하면 안 됨) S의 최솟값을 구하는 문제
 * 
 * A배열을 오름차순으로, B배열을 내림차순(오름차순으로 정렬 후 곱할 때 인덱스를 N-i-1로 지정)으로 만들어 곱해준다!
 * 
 * 
 */

public class Main {
	static int[] arrA, arrB;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arrA = new int[N];
		arrB = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		// 오름차순 정
		Arrays.sort(arrA);
		Arrays.sort(arrB);
		System.out.println(getS());
	}

	/**
	 * 함수 S를 구하는 메서드 
	 * @return 구한 S의 값 
	 */
	private static int getS() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += arrA[i] * arrB[N - i - 1];
		}
		return sum;
	}
}
