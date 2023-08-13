import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        solution(1, 0);
        System.out.println(sb);
    }

    public static void solution(int startNum, int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = startNum; i <= N; i++) {
            arr[cnt] = i;
            solution(i, cnt + 1);
        }
    }
}
