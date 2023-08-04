package ssafy.hw0804;

import java.io.*;
import java.util.*;

/**
 * 여는 문자열을 만났을 때엔 stack.push()
 * 닫는 문자열을 만났을 때엔 스택 맨 꼭대기에 저장되어 있는 값과 짝이 맞는지 비교하여 일치 시에 pop 해줌
 * 
 * 메모리: 18,856kb 실행시간 106ms
 * 
 * @author 이하늬
 * 
 */

public class Main {
	public static void main(String[] args) throws IOException {
		Stack<Character> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int len = Integer.parseInt(br.readLine());
			String str = br.readLine();
			boolean flag = true;
			for (int idx = 0; idx < len; idx++) { // 입력 받은 문자열을 한글자씩 인덱스로 접근하기 위한 반복문
				char c = str.charAt(idx);
				if (c == '(' || c == '[' || c == '{' || c == '<') { // 여는 괄호를 만났을 땐
					stack.push(c); // stack에 push 해줌
					continue; // 여는 괄호를 만났기 때문에 아래의 과정들을 수행할 필요가 없으므로 continue 해줌
				}
				// 닫는 괄호를 만났을 때엔 스택의 가장 꼭대기에 저장되어 있는 값이 짝이 맞는 여는 괄호일 시에만 pop 해줌
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
				flag = false; // 위와 같은 조건들을 다 만족하지 못할 시에는 flag를 false 값을 주고 반복문 탈출
				break;
			}
			System.out.printf("#%d %d\n", tc, flag ? 1 : 0); // boolean값에 따라 결과값 출력
		}
	}
}
