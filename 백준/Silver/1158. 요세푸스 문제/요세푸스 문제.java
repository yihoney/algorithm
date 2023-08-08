import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> list = new LinkedList<>();
        for (int n = 1; n <= N; n++) {
            list.add(n);
        }
        int baseIdx = 0;
        sb.append("<");
        while (list.size() > 1) {
            baseIdx += (K - 1);
            if (baseIdx >= list.size()) {
                baseIdx %= list.size();
            }
            sb.append(list.remove(baseIdx)).append(", ");
        }
        sb.append(list.remove(0)).append(">");
        System.out.println(sb);
    }
}