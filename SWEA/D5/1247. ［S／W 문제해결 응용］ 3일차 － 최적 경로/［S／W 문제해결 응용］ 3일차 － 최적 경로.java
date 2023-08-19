import java.io.*;
import java.util.*;

class Point {
	int x, y;

	Point(String x, String y) {
		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
	}
	
}

public class Solution {

	static Point[] customers;
	static Point company, home;
	static boolean[] isSelected;
	static int[] numbers;
	static int minDist;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			isSelected = new boolean[N];
			numbers = new int[N];
			customers = new Point[N];
			st = new StringTokenizer(br.readLine());

			company = new Point(st.nextToken(), st.nextToken());
			home = new Point(st.nextToken(), st.nextToken());
			for (int i = 0; i < N; i++) {
				customers[i] = new Point(st.nextToken(), st.nextToken());
			}
			minDist = Integer.MAX_VALUE;
			perm(0);
			sb.append("#").append(tc).append(" ");
			sb.append(minDist).append("\n");
		}
		System.out.println(sb);
	}

	public static void perm(int cnt) {
		if (cnt == customers.length) {
			getMinDist(numbers);
			return;
		}

		for (int i = 0; i < customers.length; i++) {
			if (isSelected[i]) {
				continue;
			}
			numbers[cnt] = i;
			isSelected[i] = true;
			perm(cnt + 1);
			isSelected[i] = false;
		}

	}

	private static void getMinDist(int[] customerIdxArr) {

		int dis = 0;

		for (int i = 0; i < customerIdxArr.length; i++) {
			Point customer = customers[customerIdxArr[i]];
			if (i == 0) {
				dis += Math.abs(company.x - customer.x) + Math.abs(company.y - customer.y);
			} else {
				Point prevCustomer = customers[customerIdxArr[i - 1]];
				dis += Math.abs(prevCustomer.x - customer.x) + Math.abs(prevCustomer.y - customer.y);
			}
			if (i == customerIdxArr.length - 1) {
				dis += Math.abs(customer.x - home.x) + Math.abs(customer.y - home.y);
			} 
		}

		minDist = Math.min(dis, minDist);
	}

}