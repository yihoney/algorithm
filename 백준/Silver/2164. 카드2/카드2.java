import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		for (int n = 1; n <= N; n++) {
			queue.add(n);
		}
		
		while(queue.size()!=1) {
			queue.poll();
			queue.add(queue.peek());
			queue.poll();
		}
		System.out.println(queue.peek());
	}
}
