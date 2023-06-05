package inflearn.lecture06.problem07;

import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        if (this.x == p.x) {
            return this.y - p.y;
        } else {
            return this.x - p.x;
        }
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Point> pointList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pointList.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        System.out.println(solution(n, pointList));
    }

    private static String solution(int n, List<Point> pointList) {
        StringBuilder sb = new StringBuilder();
        Collections.sort(pointList);
        for (Point p : pointList) {
            sb.append(p.x + " " + p.y + "\n");
        }
        return sb.toString();
    }
}
