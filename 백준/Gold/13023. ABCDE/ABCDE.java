import java.util.*;
import java.io.*;

/**
 * 
 * @author 이하늬
 *
 */

class Node {
	int vertex;
	Node next;

	public Node(int vertex, Node next) {
		this.vertex = vertex;
		this.next = next;
	}
}

public class Main {
	static Node arr[];
	static boolean isVisited[];
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 사람의 수
		int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수
		arr = new Node[N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a] = new Node(b, arr[a]);
			arr[b] = new Node(a, arr[b]);
		}

		for (int i = 0; i < N; i++) {
			isVisited = new boolean[N];
			ans = 0;
			dfs(i);
		}
		
		System.out.println(0);

	}

	public static void dfs(int cur) {
		isVisited[cur] = true;
		ans++;
		
		if (ans == 5) {
			System.out.println(1);
			System.exit(0);
		}

		for (Node temp = arr[cur]; temp != null; temp = temp.next) {
			if (!isVisited[temp.vertex]) {
				dfs(temp.vertex);
				isVisited[temp.vertex] = false;
			}
		}

		ans--;
	}

}