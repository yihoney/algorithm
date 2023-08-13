import java.io.*;
import java.util.*;

public class Main {

    static int N, S, ans;
    static int[] arr;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 후보군 갯수
        S = Integer.parseInt(st.nextToken()); // 합한 값의 기준
        arr = new int[N]; // 순열의 요소들이 될 숫자들의 후보군
        isSelected = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(0, 0, 0);

        System.out.println(ans);
    }

    public static void solution(int cnt, int sum, int selectedCnt) {
        if (cnt == N) {
            if (sum == S && selectedCnt > 0) {
                ans++;
            }
            return;
        }

        isSelected[cnt] = true;
        solution(cnt + 1, sum + arr[cnt], selectedCnt + 1);
        isSelected[cnt] = false;
        solution(cnt + 1, sum, selectedCnt);
    }
}
