package inflearn.lecture05.problem08;

import java.util.*;
import java.io.*;

class Patient {
    private int id;
    private int priority;

    public Patient(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }

    public int getId() {
        return this.id;
    }

    public int getPriority() {
        return this.priority;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(m, arr));
    }

    private static int solution(int m, int[] arr) {
        int ans = 0;
        Queue<Patient> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            queue.offer(new Patient(i, arr[i]));
        }
        while (!queue.isEmpty()) {
            Patient tmp = queue.poll();
            for (Patient p : queue) {
                if (p.getPriority() > tmp.getPriority()) {
                    queue.offer(tmp);
                    tmp = null;
                    break;
                }
                if (tmp != null) {
                    ans++;
                    if (tmp.getId() == m) {
                        return ans;
                    }
                }
            }
        }
        return ans;
    }
}