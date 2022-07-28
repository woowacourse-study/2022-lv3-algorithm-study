import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Position {
		int pos, count;

		public Position(int pos, int count) {
			this.pos = pos;
			this.count = count;
		}
	}

	static int N;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 1 ~ N 까지 정거장이 위치함
		int M = Integer.parseInt(st.nextToken()); // 텔레포트 개수

		st = new StringTokenizer(br.readLine());

		int S = Integer.parseInt(st.nextToken()); // 주예의 위치
		int E = Integer.parseInt(st.nextToken()); // 방주의 위치

		Map<Integer, List<Integer>> teleport = new HashMap<>();
		result = Math.abs(S - E);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			List<Integer> xValue = teleport.getOrDefault(x, new ArrayList<>());
			xValue.add(y);
			teleport.put(x, xValue);

			List<Integer> yValue = teleport.getOrDefault(y, new ArrayList<>());
			yValue.add(x);
			teleport.put(y, yValue);
		}

		bfs(teleport, S, E);
		System.out.println(result);
	}

	private static void bfs(Map<Integer, List<Integer>> teleport, int s, int e) {
		Queue<Position> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];

		q.add(new Position(s, 0));
		visited[s] = true;

		while (!q.isEmpty()) {
			Position curPos = q.poll();

			//도착
			if (curPos.pos == e) {
				result = Math.min(curPos.count, result);
				break;
			}

			//텔레포트 이동
			if (teleport.containsKey(curPos.pos)) {
				for (Integer telPos : teleport.get(curPos.pos)) {
					if (!visited[telPos]) {
						visited[telPos] = true;
						q.add(new Position(telPos, curPos.count + 1));
					}
				}
			}

			// 한칸씩 이동
			if(curPos.pos + 1 <= N && !visited[curPos.pos + 1] ){
				visited[curPos.pos + 1] = true;
				q.add(new Position(curPos.pos + 1, curPos.count + 1));
			}
			if(curPos.pos - 1 > 0 && !visited[curPos.pos - 1] ){
				visited[curPos.pos - 1]= true;
				q.add(new Position(curPos.pos - 1, curPos.count + 1));
			}
		}
	}
}