import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int answer = 0;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> marbles = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			marbles.add(Integer.parseInt(st.nextToken()));
		}

		dfs(marbles, 0, 0);

		System.out.println(answer);
	}

	private static void dfs(List<Integer> marbles, int count, int energy) {
		if (marbles.size() == 2) {
			answer = Math.max(energy, answer);
			return;
		}

		for (int i = 1; i < marbles.size() - 1; i++) {
			int marble = marbles.get(i);
			int addedEnergy = marbles.get(i - 1) * marbles.get(i + 1);
			marbles.remove(i);
			dfs(marbles, count + 1, energy + addedEnergy);
			marbles.add(i, marble);
		}
	}
}




