import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static boolean[] flag;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 후보군 갯수
        arr = new int[N]; // 순열의 요소들이 될 숫자들의 후보군
        isSelected = new boolean[N];
        flag = new boolean[100000 * 20 + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(0, 0);

        for (int num = 1; num < flag.length; num++) {
            if (!flag[num]) {
                System.out.println(num);
                break;
            }
        }

    }

    public static void solution(int cnt, int sum) {
        if (cnt == N) {
            flag[sum] = true;
            return;
        }

        isSelected[cnt] = true;
        solution(cnt + 1, sum + arr[cnt]);
        isSelected[cnt] = false;
        solution(cnt + 1, sum);
    }
}
