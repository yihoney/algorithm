package ssafy.hw0803;

import java.io.*;
import java.util.*;

/**
 * - DNA 문자열: {'A', 'C', 'G', 'T'} 부분 문자열에서 등장하는 문자의 개수가 특정 개수 이상인지 확인하는 로직 필요
 * -> 문자마다 요구하는 갯수 저장하는 배열 필요
 * 시간초과 나서 해결중
 * 
 * @author 이하늬
 * 
 */

public class Main {

    static Map<Character, Integer> DNAarr = new HashMap<>(4);
    static int cntDNAchar[], lenS, lenP;
    static String DNAstr; // 민호가 임의로 만든 DNA 문자열

    public static void main(String[] args) throws IOException {
        DNAarr.put('A', 0);
        DNAarr.put('C', 0);
        DNAarr.put('G', 0);
        DNAarr.put('T', 0);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        lenS = Integer.parseInt(st.nextToken()); // 민호가 임의로 만든 DNA 문자열 길이 |S|
        lenP = Integer.parseInt(st.nextToken()); // 비밀번호로 사용할 부분문자열의 길이 |P|
        DNAstr = br.readLine();
        cntDNAchar = new int[4]; // 문자마다 요구하는 갯수 저장하는 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cntDNAchar.length; i++) {
            cntDNAchar[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution());
    }

    public static int solution() {
        int ans = 0;

        int lt = 0;
        int rt = 0;

        while (rt < lenS) {
            if (rt - lt == lenP) {
                System.out.println(lt + "," + rt);
                // 글자와 일치하는 DNA 문자열의 요소를 찾아 cnt-1을 해줌
                DNAarr.put(DNAstr.toCharArray()[lt], DNAarr.get(DNAarr.get(DNAstr.toCharArray()[lt]) - 1));
                lt++;
                rt = lt + lenP - 1;
            }

            DNAarr.put(DNAstr.toCharArray()[lt], DNAarr.getOrDefault(0, DNAarr.get(DNAstr.toCharArray()[lt]) + 1));

            if (rt - lt == lenP - 1 && cntArr[0] >= cntDNAchar[0] && cntArr[1] >= cntDNAchar[1] && // 조건을 만족하면
                    cntArr[2] >= cntDNAchar[2] && cntArr[3] >= cntDNAchar[3]) {
                ans++;
            }
            rt++;

        }
        return ans;
    }
}
