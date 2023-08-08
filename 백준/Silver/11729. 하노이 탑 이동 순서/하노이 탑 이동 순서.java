import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb.append((int) Math.pow(2, N) - 1).append("\n");
        recursive(N, 1, 2, 3);
        System.out.println(sb);
    }

    private static void recursive(int n, int from, int tmp, int to) {
        if (n == 0) {
            return;
        }

        recursive(n - 1, from, to, tmp);
        sb.append(from).append(" ").append(to).append("\n");
        recursive(n - 1, tmp, from, to);
    }
}
