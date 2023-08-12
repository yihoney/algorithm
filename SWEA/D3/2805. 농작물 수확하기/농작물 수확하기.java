import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static int cnt = 0;
    public static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine()); // 농장의 크기
            sum = 0;
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Character.getNumericValue(str.charAt(j));
                }
            }
            solution(arr, 0);
            System.out.printf("#%d %d\n", tc, sum);
        }
    }

    public static void solution(int[][] arr, int cnt) {
        if (cnt == arr.length) { // 함수 호출 횟수가 농장 크기와 같아졌을 경우 종료
            return;
        }
        if (cnt <= arr.length / 2) { //
            for (int i = arr.length / 2 - cnt; i <= arr.length / 2 + cnt; i++) {
                sum += arr[cnt][i];
            }
        }
        if (cnt > arr.length / 2) {
            for (int i = arr.length / 2 - (arr.length - cnt - 1); i <= arr.length / 2 + (arr.length - cnt - 1); i++) {
                sum += arr[cnt][i];
            }
        }

        solution(arr, cnt + 1);
    }

}