import java.io.*;
import java.util.*;

public class Solution {
    static ArrayList<Integer>[] graph;
    static int S;
    static int[] isVisited;
    static int ans, depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            sb.append("#").append(tc).append(" ");
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken()); // 데이터의 길이
            S = Integer.parseInt(st.nextToken()); // 시작점
            ans = Integer.MIN_VALUE; // 최소 1번은 변경되기 위해 최소값으로 선언
            depth = 0; // 깊이

            // 입력받은 데이터를 그래프에 저장하기 위한 배열 생성
            graph = new ArrayList[100 + 1];
            for (int i = 1; i <= 100; i++) {
                graph[i] = new ArrayList<>();
            }

            isVisited = new int[100 + 1]; // 방문 플래그 및 깊이를 저장해둘 배열

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < L / 2; i++) { // 2개씩 한 세트이므로 L/2
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph[from].add(to);
            }

            bfs();

            for (int i = 100; i >= 1; i--) {
                if (isVisited[i] == depth) {
                    ans = i;
                    break;
                }
            }

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        // 처음 시작값 큐에 삽입 및 방문 플래그 설정
        queue.offer(S);
        isVisited[S] = 1;

        while (!queue.isEmpty()) { // 큐가 비어있을 때까지

            int cur = queue.poll();
            for (int i = 0; i < graph[cur].size(); i++) {
                int vertex = graph[cur].get(i); // 지금 볼 정점
                if (isVisited[vertex] == 0) { // 아직 방문하지 않은 정점이라면
                    queue.offer(vertex); // 큐에 삽입 및
                    isVisited[vertex] = isVisited[cur] + 1; // 방문 플래그 배열에 현재 깊이 + 1 저장
                    depth = Math.max(depth, isVisited[vertex]);
                }
            }
        }
    }

}
