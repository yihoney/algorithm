package swea.D3.D3_1228_암호문1;

import java.io.*;
import java.util.*;

/**
 * <D3 1228 - 암호문1>
 * 
 * 명령어 I x,y,s: 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입
 * -> LinkedList를 이용해 x 노드 앞에 y개의 데이터 삽입
 * 처음 10개 항을 출력
 * 
 * 메모리: 18,344KB, 시간: 120ms
 * 
 * @author 이하늬
 */

public class D3_1228_SW문제해결기본1일차8일차_암호문1_이하늬 {
    static StringBuilder sb = new StringBuilder();
    static List<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            sb.append("#").append(tc).append(" ");
            int N = Integer.parseInt(br.readLine()); // 원본 암호문의 길이
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int commandN = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()); // 명령어 갯수
            for (int i = 0; i < commandN; i++) { // 명령어 갯수만큼 반복
                editPassword(st);
            }

            for (int i = 0; i < 10; i++) { // 처음 10개 항 sb에 추가
                sb.append(list.get(i)).append(" ");
            }

            sb.append("\n");
            list.clear(); // list 초기화
        }

        System.out.println(sb);
    }

    private static void editPassword(StringTokenizer st) {
        st.nextToken(); // 명령어 I
        int idx = Integer.parseInt(st.nextToken()); // 삽입할 인덱스 위치
        int n = Integer.parseInt(st.nextToken()); // 삽입할 갯수
        for (int i = 0; i < n; i++) {
            list.add(idx++, Integer.parseInt(st.nextToken())); // idx에 데이터 삽입 (삽입한 후 idx+1)
        }
    }
}
