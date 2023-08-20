import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static int arr[][];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken()) - 1;

        arr = new int[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            arr[start][end] = arr[end][start] = 1;
        }

        dfs(V);
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }

    private static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        boolean[] isVisited = new boolean[N];

        stack.push(start);

        while (!stack.isEmpty()) {
            int cur = stack.pop();

            if (isVisited[cur]) {
                continue;
            }

            isVisited[cur] = true;
            sb.append((cur + 1) + " ");

            for (int i = N - 1; i >= 0; i--) {
                if (arr[cur][i] != 0 && !isVisited[i]) {
                    stack.push(i);
                }
            }
        }

    }

    private static void bfs(int start) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[N];
        queue.offer(start);
        isVisited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append((cur + 1) + " ");

            for (int i = 0; i < N; i++) {
                if (arr[cur][i] != 0 && !isVisited[i]) {
                    queue.offer(i);
                    isVisited[i] = true;
                }
            }
        }

    }
}
