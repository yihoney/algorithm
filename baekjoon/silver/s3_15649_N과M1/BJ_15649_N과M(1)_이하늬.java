package baekjoon.silver.s3_15649_N과M1;

import java.util.*;
import java.io.*;

/**
 * 
 * @author 이하늬
 * 
 *         <pre>
 *          1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 출력
 *          중복 없이 출력하기 위해 방문 플래그를 저장해둘 배열을 생성해 방문했을 경우 플래그를 true로 변경
 * 
 *          메모리: 22448KB, 시간: 296ms
 *         </pre>
 * 
 * @author 이하늬
 *
 */

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int n = 0;
    public static int m = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        boolean[] isVisited = new boolean[n]; // 방문 여부 저장해둘 배열
        int[] ans = new int[m]; // 수열을 저장해둘 배열
        recur(0, ans, isVisited);
        System.out.println(sb.toString());
    }

    public static void recur(int cnt, int[] ans, boolean[] isVisited) {
        if (cnt == m) { // 호출 횟수가 M과 같아지면 호출 안함
            for (int i = 0; i < ans.length; i++) {
                sb.append(ans[i]); // stringbuilder에 자연수 추가
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (isVisited[i - 1] == true) { // 이미 방문한 자연수라면
                continue;
            }
            ans[cnt] = i; //
            isVisited[i - 1] = true; // 방문 플래그 true로 변경
            recur(cnt + 1, ans, isVisited); // 호출 횟수를 +1 해서 호출
            isVisited[i - 1] = false; // 방문 플래그 false로 변경
        }
    }

}
