import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		int cnt = 1;

		List<String> result = new ArrayList<>();

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		while (!q.isEmpty()) {
			if (cnt == K) {
				result.add(q.poll().toString());
				cnt = 1;
			} else {
				cnt++;
				q.add(q.poll());
			}
		}
		System.out.println("<" + String.join(", ", result) + ">");
	}
}
