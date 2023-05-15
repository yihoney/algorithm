package inflearn.lecture03.problem06;

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

    private static int solution(int n, int k, int[] arr) {
        int ans = 0;
        int lt = 0;
        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) {
                k--;
            }
            while (k > 0) {
                if (arr[lt] == 0) {
                    k++;
                }
                lt++;
            }
            ans = Math.max(ans, rt - lt + 1);
        }
        return ans;
    }
}
