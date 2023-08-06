package baekjoon.silver.s5_17478_재귀함수가뭔가요;

import java.io.*;

/**
 * @author 이하늬
 * 
 *         <pre>
 *         문제 - 백준 17478 재귀함수가뭔가요
 *         아이디어
 *         - 반복한 횟수가 출력 하고자 하는 횟수 n번을 넘기 전 / 같아졌을 경우를 나뉘어서 답변
 *         - 재귀 호출을 마친 다음 "라고 답변하였지."로 마무리
 * 
 *         - 메모리: 14732KB, 시간: 140ms
 *         </pre>
 */

public class Main {
    public static StringBuilder sb = new StringBuilder();

    private static void recursive(int r, int n) {
        print(r);
        sb.append("\"재귀함수가 뭔가요?\"\n");

        if (r < n) { // 반복한 횟수가 출력 하고자 하는 횟수 n번을 넘기 전
            print(r);
            sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
            print(r);
            sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
            print(r);
            sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
            recursive(r + 1, n);
        }

        if (r == n) { // 반복한 횟수가 출력 하고자 하는 횟수 n번과 같아졌을 경우
            print(r);
            sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
        }

        print(r);
        sb.append("라고 답변하였지.\n");

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        recursive(0, n);
        System.out.println(sb.toString());
    }

    public static void print(int n) {
        for (int i = 0; i < n; i++) {
            sb.append("____");
        }
    }
}