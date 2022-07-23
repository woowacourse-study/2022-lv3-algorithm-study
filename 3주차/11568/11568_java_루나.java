import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[] inputs = Arrays.stream(br.readLine().split(" "))
			.mapToLong(Long::parseLong)
			.toArray();
		int[] d = new int[N];

		for (int i = 0; i < N; i++) {
			d[i] = 1;
			for (int j = 0; j < i; j++) {
				if (inputs[j] < inputs[i] && d[i] < d[j] + 1) {
					d[i] = d[j] + 1;
				}
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i : d) {
			max = Math.max(max, i);
		}
		System.out.println(max);
	}
}
