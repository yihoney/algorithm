package inflearn.lecture06.problem04;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(s, arr));
    }

    private static String solution(int s, int[] arr) {
        StringBuilder ans = new StringBuilder();

        LinkedList<Integer> cache = new LinkedList<>();

        for (int n : arr) {
            if (cache.contains(n)) {
                cache.remove((Integer) n);
            }
            cache.addFirst(n);

            if (cache.size() > s) {
                cache.removeLast();
            }
        }

        for (int n : cache) {
            ans.append(n + " ");
        }

        return ans.toString();
    }
}