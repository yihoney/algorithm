package baekjoon.silver.s5_1181_단어정렬;

import java.io.*;
import java.util.*;

/**
 * @author 이하늬
 * 
 *         <pre>
 *         문제 - 백준 1181 (단어 정렬)
 *         - 길이가 짧은 것부터 (이가 같으면 사전 순으로 정렬)
 *         - 중복된 단어는 하나만 남기고 제거
 *         </pre>
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] strArr = new String[num];
        for (int i = 0; i < num; i++) {
            strArr[i] = br.readLine();
        }
        System.out.println(solution(num, strArr));
    }

    private static String solution(int num, String[] strArr) {

        Arrays.sort(strArr, (s1, s2) -> { // 문자열 배열 정렬하기 위해 Arrays.sort 재정의
            if (s1.length() == s2.length()) { // 길이가 같다면 사전순으로 정렬
                return s1.compareTo(s2);
            } else {
                return s1.length() - s2.length(); // 연산 결과가 양수일 경우 s1의 길이가 더 길은 것
            }
        });

        StringBuilder ans = new StringBuilder();

        ans.append(strArr[0]).append("\n"); // 비교하기 위해 우선 첫번째 단어 등록

        for (int i = 1; i < num; i++) {
            if (!strArr[i - 1].equals(strArr[i])) { // 앞의 문자열과 같지 않은 것만 답에 추가
                ans.append(strArr[i]).append('\n');
            }
        }

        return ans.toString();
    }
}