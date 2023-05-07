import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[num][5];
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(num, arr));
    }

    private static int solution(int num, int[][] arr) {
        int ans = 0;
        int tmp = Integer.MIN_VALUE;
        for (int i = 0; i < num; i++) {
            int cnt = 0;
            for (int j = 0; j < num; j++) {
                for (int k = 0; k < 5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (tmp < cnt) {
                ans = i + 1;
                tmp = cnt;
            }
        }
        return ans;
    }
}