package baekjoon.silver.s4_1158_요세푸스문제;

import java.io.*;
import java.util.*;

/**
 * <백준 1158 - 요세푸스 문제>
 * 
 * (N,K)-요세푸스 순열: N이 0이 될 때까지 K번째 사람을 제거
 * 
 * K번째 사람을 제거 후에 다시 처음 인덱스부터 K번째가 아닌,
 * 삭제한 사람의 기존 인덱스 + K 번째 사람을 제거해야함
 * 
 * 만약 제거해야하는 사람의 인덱스가 리스트의 크기보다 크다면,
 * 리스트의 크기로 인덱스를 나눈 나머지로 인덱스를 설정
 * 
 * 메모리: 14792KB, 시간: 168ms
 * 
 * @author 이하늬
 */

public class BJ_1158_요세푸스문제_이하늬 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new LinkedList<>();

        for (int n = 1; n <= N; n++) {
            list.add(n); // list에 1 ~ N 추가
        }

        int baseIdx = 0; // 초깃값 0으로 설정
        sb.append("<");
        while (list.size() > 1) { // List에 남아있는 데이터가 1 이상일 때까지 반복
            baseIdx += (K - 1); // 제거할 사람의 인덱스 설정
            if (baseIdx >= list.size()) { // 삭제할 idx가 남아있는 데이터의 갯수보다 크면
                baseIdx %= list.size(); // list 크기로 나눠서 인덱스 재설정
            }
            sb.append(list.remove(baseIdx)).append(", "); // startIdx+K번째 데이터 삭제
        }
        sb.append(list.remove(0)).append(">"); // 마지막 데이터 sb에 추가

        System.out.println(sb);
    }
}
