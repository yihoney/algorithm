import java.io.*;

public class Main {

    static int N;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isSelected = new boolean[N + 1];
        arr = new int[N];
        permutation(0);
        System.out.println(sb);
    }

    public static void permutation(int cnt) {
        if (cnt == N) {
            for (int i = 0; i < N; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (isSelected[i]) {
                continue;
            }
            arr[cnt] = i;
            isSelected[i] = true;
            permutation(cnt + 1);
            isSelected[i] = false;
        }
    }
}
