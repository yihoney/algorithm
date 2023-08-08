package swea.D4.D4_1233_사칙연산유효성검사;

import java.io.*;
import java.util.*;

/**
 * <계산이 가능한 경우>
 * - 연산자 1개, 피연산자 2개를 가져야 함
 * - 피연산자는 단말 노드에 와야함. 루트 노드에 오면 안됨
 * 
 * 메모리: 20,684kb / 실행시간: 113ms
 * 
 * @author 이하늬
 */

public class D4_1233_사칙연산유효성검사_이하늬 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) { // 총 10번 반복
            int N = Integer.parseInt(br.readLine()); // 총 정점 갯수
            sb.append("#").append(tc).append(" ");
            int ans = 1; // 기본값을 1로 설정

            for (int n = 1; n <= N; n++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken(); // 정점 번호 버림
                char node = st.nextToken().charAt(0); // 첫번째 데이터

                if (st.hasMoreTokens()) { // 단말노드가 아닐 경우
                    if (Character.isDigit(node)) { // 첫번째 데이터가 숫자라면
                        ans = 0; // 연산 불가
                    }
                } else { // 단말노드일 경우
                    if (!Character.isDigit(node)) { // 숫자가 아니라면
                        ans = 0; // 연산 불가
                    }
                }
            }
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
