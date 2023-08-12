import java.io.*;
import java.util.*;

public class Solution {
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
