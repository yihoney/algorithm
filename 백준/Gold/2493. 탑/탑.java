import java.io.*;
import java.util.*;

class Top {
    int index;
    int height;

    public Top(int index, int height) {
        this.index = index;
        this.height = height;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Stack<Top> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            Top newTop = new Top(i, Integer.parseInt(st.nextToken()));
            while (true) {
                if (stack.isEmpty()) { 
                    stack.push(newTop);
                    sb.append("0 ");
                    break;
                } else {
                    Top top = stack.peek();
                    if (top.height > newTop.height) {
                        sb.append(top.index).append(" ");
                        stack.push(newTop);
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        System.out.println(sb);
    }
}