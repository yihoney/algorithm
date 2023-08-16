import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static long C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        long ans = pow(A, B);
        System.out.println(ans);
    }

    private static long pow(long A, long B) {
        if (B == 1) {
            return A % C;
        }

        long res = pow(A, B / 2);
        return (B % 2 == 0) ? res * res % C : (res * res % C) * A % C;
    }
}
