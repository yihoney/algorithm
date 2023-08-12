import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;

		while (N > 0) {
			if (N % 5 == 0) {
				N -= 5;
				ans++;
			}
			else {
				N -= 3;
				ans++;
			}
			
		}

		if (N >= 0) {
			System.out.println(ans);
		} else {
			System.out.println(-1);
		}

	}
}
