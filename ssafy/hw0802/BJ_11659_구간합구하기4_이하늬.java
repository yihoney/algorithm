import java.io.*;
import java.util.*;

/**
 * 
 * @author 이하늬
 * 
 *         <pre>
 * 			- 구간합을 빠르게 구하기 위해 prefix sum을 사용 -> 입력 시부터 입력 값에 인덱스 전까지 해당하는 모든 값들을 더해서 저장
 * 			- 값을 저장해둔 배열에서 start ~ end 구간의 구간합은 arr[end] - arr[start-1]을 계산하여 바로 구할 수 있음
 * 
 *          메모리: 53176KB, 시간: 548ms
 *         </pre>
 * 
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken()); // prefix-sum
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int startIdx = Integer.parseInt(st.nextToken());
            int endIdx = Integer.parseInt(st.nextToken());
            int sum = arr[endIdx] - arr[startIdx - 1]; // arr[end] - arr[start-1]
            sb.append(sum);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
