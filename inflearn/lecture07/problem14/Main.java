package inflearn.lecture07.problem14;

import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<ArrayList<Integer>> graph;
    static int[] check;
    static int[] dist;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        check = new int[n + 1];
        dist = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }
        BFS(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + dist[i]);
        }
    }

    private static void BFS(int vtx) {
        Queue<Integer> queue = new LinkedList<>();
        check[vtx] = 1;
        dist[vtx] = 0;
        queue.add(vtx);
        while (!queue.isEmpty()) {
            int curVtx = queue.poll();
            for (int nv : graph.get(curVtx)) {
                if (check[nv] == 0) {
                    check[nv] = 1;
                    queue.add(nv);
                    dist[nv] = dist[curVtx] + 1;
                }
            }
        }
    }
}
