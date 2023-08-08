import java.io.*;
import java.util.*;

/**
 * 젤 무거운 과자 `2봉지`를 사야 함 -> 최대 무게 합 출력
 */

public class Solution {
    static int[] arr;
    static int N, M, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트케이스 갯수
        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            ans = -1; // 정답값 초기화
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 과자 종류 갯수
            M = Integer.parseInt(st.nextToken()); // 제한 합 무게
            st = new StringTokenizer(br.readLine());

            arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken()); // 과자 무게 배열에 저장
            }

            solution(0, 0, 0);
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void solution(int idx, int sum, int cnt) {
        if (sum > M) { // 과자의 합이 제한 무게를 넘어가는 경우 종료
            return;
        }

        if (cnt == 2) { // 선택한 과자의 갯수가 2개인 경우
            ans = Math.max(ans, sum); // 기존의 최댓값과 현재 과자 무게의 합을 비교해 최대값을 ans에 저장
            return;
        }

        if (idx >= N) { // 선택할 과자의 인덱스가 과자 총 갯수를 넘어서는 경우 종료
            return;
        }

        // idx + 1번째 과자를 선택한 경우
        // -> 선택한 과자의 무게를 더하고 선택 갯수를 1개 늘려 전달
        solution(idx + 1, sum + arr[idx], cnt + 1);
        // idx + 1번째 과자를 선택 안 한 경우
        // -> 선택한 과자의 무게를 더하지 않았으니 기존의 합한 값과 선택 갯수 전달
        solution(idx + 1, sum, cnt);
    }
}
