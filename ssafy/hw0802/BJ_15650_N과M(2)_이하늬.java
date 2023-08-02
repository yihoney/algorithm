import java.io.*;
import java.util.*;

/**
 * 
 * @author 이하늬
 * 
 *         <pre>
 * 			1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 구하기 -> 단순 조합
 * 
 *          메모리: 14224KB, 시간: 120ms
 *         </pre>
 * 
 */

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N = 0;
	static int M = 0;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 1부터 N까지 자연수
		M = Integer.parseInt(st.nextToken()); // 고를 갯수
		arr = new int[M]; // 값 저장 위한 배열 생성 -> M 자릿수
		solution(1, 0);
		System.out.println(sb);
	}

	private static void solution(int start, int cnt) {
		if (cnt == M) { //
			for (int i = 0; i < M; i++) { // 배열에 저장해둔 값들 stringBuilder에 추가
				sb.append(arr[i]);
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}

		// 이전에 뽑은 수는 뽑지 않게끔 다음 자릿수엔 이전에 뽑은 수 +1부터 시작
		for (int i = start; i <= N; i++) {
			arr[cnt] = i;
			solution(i + 1, cnt + 1);
		}

	}

}