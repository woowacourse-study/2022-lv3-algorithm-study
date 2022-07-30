import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] sum = new int[2][N];

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					int token = Integer.parseInt(st.nextToken());
					// 세로줄, 가로줄의 합만 계신
					sum[0][j] += token;
					sum[1][k] += token;
				}
			}

			for (int j = 0; j < M; j++) {
				int[] operations = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

				int r1 = operations[0] - 1;
				int c1 = operations[1] - 1;
				int r2 = operations[2] - 1;
				int c2 = operations[3] - 1;
				int v = operations[4];

				//합만 계산
				for (int k = r1; k <= r2; k++) {
					sum[0][k] += (c2 - c1 + 1) * v;
				}
				for (int k = c1; k <= c2; k++) {
					sum[1][k] += (r2 - r1 + 1) * v;
				}
			}

			StringBuilder sb = new StringBuilder();
			for (int[] ints : sum) {
				for (int anInt : ints) {
					sb.append(anInt).append(" ");
				}
				sb.append("\n");
			}

			System.out.print(sb);
		}

	}
}
