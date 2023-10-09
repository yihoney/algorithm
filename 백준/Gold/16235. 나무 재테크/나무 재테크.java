import java.io.*;
import java.util.*;

class Tree {
	int x, y, age;
	
	Tree(int x, int y, int age) {
		this.x=x;
		this.y=y;
		this.age=age;
	}
}

public class Main {
	static int N, M, K;
	static int A[][], map[][];
	static List<Tree> trees;
	static Queue<Tree> deadTrees;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 추가되는 양분의 양 입력 받기
		A = new int[N][N];
		map = new int[N][N];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < N; m++) {
				A[n][m] = Integer.parseInt(st.nextToken());
				// 가장 처음에 양분은 모든 칸에 5만큼 들어있음
				map[n][m] = 5;
			}
		}

		// 심은 나무 x좌표, y좌표, 나이 입력 받기
		trees = new LinkedList<>();
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			Tree tree = new Tree(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()));
			trees.add(tree);
		}

		Collections.sort(trees, (o1, o2) -> o1.age - o2.age);

		deadTrees = new ArrayDeque<>();

		for (int k = 0; k < K; k++) {
			spring();
			summer();
			fall();
			winter();
		}

		System.out.println(trees.size());
	}

	private static void spring() {
		Iterator<Tree> iterator = trees.iterator();
		while (iterator.hasNext()) {
			Tree tree = iterator.next();

			if (map[tree.x][tree.y] >= tree.age) {
				map[tree.x][tree.y] -= tree.age;
				tree.age += 1;
			} else {
				deadTrees.offer(tree);
				iterator.remove(); // 트리목록에서 삭제
			}
		}
	}

	private static void summer() {

		while (!deadTrees.isEmpty()) {
			Tree tree = deadTrees.poll();
			map[tree.x][tree.y] += tree.age / 2;
		}

	}

	private static void fall() {
		int[][] dirs = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

		LinkedList<Tree> newTrees = new LinkedList<>();

		for (Tree tree : trees) {

			if (tree.age % 5 == 0) {
				for (int d = 0; d < dirs.length; d++) {
					int nx = tree.x + dirs[d][0];
					int ny = tree.y + dirs[d][1];

					if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
						continue;
					}

					newTrees.add(new Tree(nx, ny, 1));
				}
			}
		}

		// 맨 앞에 새롭게 생긴 나무들 삽입
		trees.addAll(0, newTrees);

	}

	private static void winter() {
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < N; m++) {
				map[n][m] += A[n][m];
			}
		}
	}
	
}