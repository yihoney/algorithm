import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str));
    }

    private static int solution(String str) {
        int ans = Integer.MAX_VALUE;
        String[] arr = str.split("-");

        for (int i = 0; i < arr.length; i++) {
            int tmp = 0;
            String[] tmpArr = arr[i].split("\\+");

            for (int j = 0; j < tmpArr.length; j++) {
                tmp += Integer.parseInt(tmpArr[j]);
            }

            if (ans == Integer.MAX_VALUE) {
                ans = tmp;
            } else {
                ans -= tmp;
            }
        }
        return ans;
    }
}
