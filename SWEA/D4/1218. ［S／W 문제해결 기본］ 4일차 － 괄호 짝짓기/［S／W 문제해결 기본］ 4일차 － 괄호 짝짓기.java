import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		Stack<Character> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int len = Integer.parseInt(br.readLine());
			String str = br.readLine();
			boolean flag = true;
			for (int idx = 0; idx < len; idx++) {
				char c = str.charAt(idx);
				if (c == '(' || c == '[' || c == '{' || c == '<') {
					stack.push(c);
					continue;
				}
				if (c == ')' && stack.peek() == '(') {
					stack.pop();
					continue;
				}
				if (c == ']' && stack.peek() == '[') {
					stack.pop();
					continue;
				}
				if (c == '}' && stack.peek() == '{') {
					stack.pop();
					continue;
				}
				if (c == '>' && stack.peek() == '<') {
					stack.pop();
					continue;
				}
				flag = false;
				break;
			}
			System.out.printf("#%d %d\n", tc, flag?1:0);
		}
	}
}