import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
//		long start = System.nanoTime();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기 위한 입력 객체 생성
		StringBuilder sb = new StringBuilder(); // 출력을 위한 StringBuilder 객체 생성
		int T = Integer.parseInt(br.readLine()); // 요리시간 T
		int[] button = new int[] { 300, 60, 10 }; // 5분, 1분, 10초를 초로 변환한 값을 배열에 저장
		int[] ans = new int[button.length]; // 각 버튼 당 몇 번을 눌러야 하는지 저장할 배열

		// 최소버튼 조작을 위해 소요시간이 큰 버튼부터 계산
		ans[0] = T / button[0]; // 5분 동작하는 버튼이 필요한 횟수
		T %= button[0]; // 남은 시간은 5분 버튼을 누른 후의 나머지
		ans[1] = T / button[1]; // 1분 동작하는 버튼이 필요한 횟수
		T %= button[1]; // 남은 시간은 1분 버튼을 누른 후의 나머지
		ans[2] = T / button[2];  // 10초 동작하는 버튼이 필요한 횟수
		T %= button[2]; // 남은 시간은 10초 버튼을 누른 후의 나머지

		if (T != 0) { // 남은 굽는 시간이 0이 아니라면 3개의 버튼으로 요리시간 T초를 정확히 맞출 수 없으므로
			sb.append(-1); // -1 출력
		} else { // 버튼으로 T초를 정확히 맞출 수 있는 경우
			for (int btnN : ans) {
				sb.append(btnN).append(" "); // 구한 버튼 횟수들을 차례대로 StringBuilder에 추가
			}
		}
		
		System.out.println(sb);

//		long end = System.nanoTime();
//		System.out.println((double)(end-start)/1_000_000_000);
	}

}
