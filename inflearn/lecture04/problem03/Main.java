package inflearn.lecture04.problem03;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, k, arr));
    }

    private static String solution(int n, int k, int[] arr) {
        StringBuilder ans = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        ans.append(map.size());
        int lt = 0;
        for (int rt = k; rt < n; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            map.put(arr[lt], map.getOrDefault(arr[lt], 0) - 1);
            if (map.get(arr[lt]) <= 0) {
                map.remove(arr[lt]);
            }
            ans.append(" " + map.size());
            lt++;
        }
        return ans.toString();
    }
}
