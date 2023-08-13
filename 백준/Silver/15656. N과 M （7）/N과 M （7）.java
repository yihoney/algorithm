import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    static int[] numbers;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 후보군 갯수
        M = Integer.parseInt(st.nextToken()); // 뽑을 갯수
        arr = new int[N]; // 순열의 요소들이 될 숫자들의 후보군
        numbers = new int[M]; // 선택한 순열을 저장할 배열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        solution(0);

        System.out.println(sb);
    }

    public static void solution(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(numbers[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            numbers[cnt] = arr[i];
            solution(cnt + 1);
        }
    }
}
