package baekjoon.problem1541;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author 이하늬
 * 
 *         <pre>
 *         문제 - 백준 1541 (잃어버린 괄호)
 *         풀이방법
 *         1. - 연산자 기준으로 입력 문자열을 분리한다
 *         2. + 연산자 기준으로 다시 한 번 분리한다
 *         3. 분리한 값들 더하기
 *         4. 더한 값들 끼리 빼주기
 *         </pre>
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 콘솔에서 데이터를 입력 받기 위해 Buffer 이용
        String str = br.readLine(); // 라인 단위로 식을 입력 받음
        System.out.println(solution(str)); // 메서드 리턴값을 출력
    }

    private static int solution(String str) {
        int ans = Integer.MAX_VALUE; // 최소값을 발견하기 위해 초깃값을 정수의 최대값으로 설정
        StringTokenizer st = new StringTokenizer(str, "-"); // 입력받은 문자열을 "-" 연산자 기준으로 분리

        while (st.hasMoreTokens()) { // "-" 연산자 기준으로 나뉜 토큰들이 더이상 존재하지 않을 때까지 반복문 실행
            int tmp = 0; // 임시로 값을 저장할 변수 선언, 값은 0으로 초기화
            String[] tmpArr = st.nextToken().split("\\+"); // "-" 연산자 기준으로 나뉜 토큰을 "+" 연산자 기준으로 분리

            for (String s : tmpArr) {
                tmp += Integer.parseInt(s); // "+" 기준으로 분리된 값들을 다 더해 tmp에 저장
            }

            if (ans == Integer.MAX_VALUE) { // 첫번째 토큰일 경우
                ans = tmp; // tmp 값은 첫번째 수 (첫번째 수는 양수가 되어야 함)
            } else { // 두번째 토큰부터는
                ans -= tmp; // 기존의 ans 값에서 빼줌
            }
        }
        return ans; // 최종으로 ans 리턴
    }
}
