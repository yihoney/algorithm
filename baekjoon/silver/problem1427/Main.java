package string.problem1427;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] strArr = br.readLine().toCharArray();
        Arrays.sort(strArr);
        for (int i = strArr.length - 1; i >= 0; i--) {
            System.out.print(strArr[i]);
        }
    }
}
