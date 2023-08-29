import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int[] memo = new int[X + 1];
//		recur(X,0);

		for (int i = 2; i <= X; i++) {
			memo[i] = memo[i - 1] + 1;

			if (i % 2 == 0) {
				memo[i] = Math.min(memo[i], memo[i / 2] + 1);
			}

			if (i % 3 == 0) {
				memo[i] = Math.min(memo[i], memo[i / 3] + 1);
			}
		}

		System.out.println(memo[X]);

	}

//	public static void recur(int X, int cnt) {
//
//		if (X == 1) {
//			ans = Math.min(cnt, ans);
//			return;
//		}
//
//		if (cnt > ans) {
//			return;
//		}
//
//		if (X % 3 == 0) {
//			recur(X / 3, cnt + 1);
//		}
//
//		if (X % 2 == 0) {
//			recur(X / 2, cnt + 1);
//		}
//		
//		recur(X - 1, cnt + 1);
//
//	}
}