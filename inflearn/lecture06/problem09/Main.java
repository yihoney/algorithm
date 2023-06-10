package inflearn.lecture06.problem09;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, m, arr));
    }

    private static int solution(int n, int m, int[] arr) {
        int ans = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (calDVDNum(mid, arr) > m) {
                lt = mid + 1;
            } else {
                ans = mid;
                rt = mid - 1;
            }
        }
        return ans;
    }

    private static int calDVDNum(int size, int[] arr) {
        int cnt = 1;
        int sum = 0;
        for (int n : arr) {
            if (sum + n <= size) {
                sum += n;
            } else {
                cnt++;
                sum = n;
            }
        }
        return cnt;
    }
}