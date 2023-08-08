package baekjoon.gold.g5_2493_탑;

import java.io.*;
import java.util.*;

/**
 * <백준 2493 - 탑>
 * 
 * 자신보다 높이가 높은 탑 중 가장 가까운 탑이 신호 수신
 * 
 * 스택에 원래의 위치와 높이를 가지는 Top 객체들을 저장
 * 
 * 메모리: 86812KB, 시간: 928ms
 * 
 * @author 이하늬
 */
class Top {
    int index;
    int height;

    public Top(int index, int height) {
        this.index = index;
        this.height = height;
    }
}

public class BJ_2493_탑 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Stack<Top> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) { // 탑의 인덱스는 1부터 시작
            Top newTop = new Top(i, Integer.parseInt(st.nextToken()));
            while (true) {
                if (stack.isEmpty()) { // 스택이 비어있다면
                    stack.push(newTop); // 스택에 새로운 탑 push
                    sb.append("0 "); // 수신하는 탑이 존재하지 않으므로 0 출력
                    break;
                } else { // 스택이 비어있지 않다면
                    Top top = stack.peek(); // 가장 위에 있는 탑
                    if (top.height > newTop.height) { // 가장 위에 있는 탑 높이가 새로운 탑보다 높다면
                        sb.append(top.index).append(" "); // 가장 위에 있는 탑 인덱스 출력
                        stack.push(newTop); // 새로운 탑 스택에 추가
                        break;
                    } else { // 가장 위에 있는 탑이 새로운 탑보다 높이가 작다면
                        // 어차피 가려지니까 스택에서 삭제
                        stack.pop();
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
