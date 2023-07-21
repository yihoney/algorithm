package string.problem9012;

import java.util.*;

/**
 * @author 이하늬
 * 
 *         <pre>
 *         문제 - 백준 9012 (괄호)
 *         아이디어
 *         - 스택을 활용
 *         - 여는 괄호가 나왔을 때 stack에 push
 *         - 닫는 괄호가 나왔을 땐 
 *          1) stack이 비어있을 경우 짝이 맞지 않으므로 종료
 *          2) stack이 비어있지 않다면 stack에서 pop 수행
 *         </pre>
 */

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] strArr = new String[num];
        Main main = new Main();
        for (int i = 0; i < num; i++) {
            strArr[i] = sc.next();
        }
        for (int i = 0; i < num; i++) {
            System.out.println(main.solution(num, strArr[i]));
        }
        sc.close();
    }

    private String solution(int num, String str) {
        String ans = "";

        Stack<Character> stack = new Stack<>();
        for (int j = 0; j < str.length(); j++) { // 문자열을 0번 인덱스부터 차례로 비교해줌
            char c = str.charAt(j);

            if (c == '(') { // 여는 괄호라면 stack에 push
                stack.push(c);
            } else { // 닫는 괄호라면
                if (stack.isEmpty()) { // stack이 비어있다면 짝이 맞지 않으므로 바로 "NO"를 리턴
                    return "NO";
                } else { // stack이 비어있지 않다면 stack에서 pop
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) { // stack이 비어있다면 괄호의 짝이 다 맞은 것이므로 "YES" 리턴
            ans = "YES";
        } else {
            ans = "NO"; // stack에 여는 괄호가 남아있다면 짝이 다 맞지 않으므로 "NO" 리턴
        }
        return ans;
    }
}
