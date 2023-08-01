package ssafy.hw0731;

import java.io.*;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        solution(N);
        System.out.println(sb);
    }

    private static void solution(int n) {
        if (n > 0) {

            solution(n - 1);
        }
    }
}
