import java.io.*;
import java.util.*;

public class Solution {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[100];
        for (int tc = 1; tc <= 10; tc++) {
            int dumpN = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            solution(tc, arr, dumpN, 0);
        }
        System.out.println(sb);
    }

    private static void solution(int tc, int[] arr, int dumpN, int cnt) {

        if (dumpN == cnt) { 
            sb.append(String.format("#%d ", tc));
            Arrays.sort(arr); 
            sb.append(arr[99] - arr[0]);
            sb.append("\n");
            return;
        }

        Arrays.sort(arr); 

        arr[0]++; 
        arr[99]--;

        solution(tc, arr, dumpN, cnt + 1);
    }
}
