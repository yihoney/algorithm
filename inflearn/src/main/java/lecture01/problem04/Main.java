package lecture01.problem04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String[] strArr = new String[num];

        for (int i = 0; i < num; i++) {
            strArr[i] = scanner.next();
        }

        for (String word : solution(strArr)) {
            System.out.println(word);
        }
    }

    private static List<String> solution(String[] strArr) {
        List<String> ansArr = new ArrayList<>();

        for (String word : strArr) {
            String rvsStr = new StringBuilder(word).reverse().toString();
            ansArr.add(rvsStr);
        }

        return ansArr;
    }

}