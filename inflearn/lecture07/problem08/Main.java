package inflearn.lecture07.problem08;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        System.out.println(solution(s, e));
    }

    private static int solution(int s, int e) {
        int ans = 0;
        int[] dist = { 1, -1, 5 };
        int[] check;
        Queue<Integer> queue = new LinkedList<>();
        check = new int[10001];
        check[s] = 1;
        queue.add(s);
        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int curNum = queue.poll();
                for (int n : dist) {
                    int childNum = curNum + n;
                    if (childNum == e) {
                        return level;
                    }
                    if (childNum >= 1 && childNum <= 10000 && check[childNum] == 0) {
                        check[childNum] = 1;
                        queue.add(childNum);
                    }
                }
            }
            level++;
        }
        return ans;
    }
}
