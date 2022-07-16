import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		int DIVISOR = 1000000007;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long[] input = Arrays.stream(br.readLine().split(" "))
			.mapToLong(Long::parseLong)
			.toArray();

		long sum = Arrays.stream(input).sum();
		long result = 0;

		for (long i : input) {
			sum -= i;
			result += sum * i;
			result %= DIVISOR;
		}

		System.out.println(result);
	}
}
