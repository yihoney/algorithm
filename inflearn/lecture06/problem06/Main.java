package inflearn.lecture06.problem06;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, arr));
    }

    private static String solution(int n, int[] arr) {
        StringBuilder ans = new StringBuilder();
        int[] tmp = arr.clone();
        Arrays.sort(tmp);

        for (int i = 0; i < n; i++) {
            if (arr[i] != tmp[i]) {
                ans.append((i + 1) + " ");
            }
        }

        return ans.toString();
    }
}