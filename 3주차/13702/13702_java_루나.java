import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 막걸리 주전자 개수
		long[] kettles = new long[N]; // 주전자 배열

		long maxMak = Integer.MAX_VALUE; // 막걸리 최대 용량
		long minMak = 1; //막걸리 최소용량
		long answer = 0;

		int K = Integer.parseInt(st.nextToken()); // 친구들의 수

		for (int i = 0; i < N; i++) {
			kettles[i] = Long.parseLong(br.readLine());
		}

		while (minMak <= maxMak) {
			midMak = (minMak + maxMak) / 2;
			int sharePeople = 0;

			for (long kettle : kettles) {
				sharePeople += kettle/midMak;
			}

			if (sharePeople < K) {
				maxMak = midMak - 1;
			}else {
				answer = midMak;
				minMak = midMak + 1;
			}
		}
		System.out.println(answer);

	}
}
