import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Position {
		int x, y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];

		//값 집어넣음
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int R = Integer.parseInt(st.nextToken());
				int G = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());

				int pixel = (R + G + B) / 3;

				map[i][j] = pixel;
			}
		}

		int T = Integer.parseInt(br.readLine());

		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] >= T) {
					bfs(visited, map, T, i, j);
					result++;
				}
			}
		}

		System.out.println(result);
	}

	private static void bfs(boolean[][] visited, int[][] map, int T, int x, int y) {
		Queue<Position> q = new LinkedList<>();
		q.add(new Position(x, y));
		visited[x][y] = true;

		while (!q.isEmpty()) {
			Position now = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (!visited[nx][ny] && map[nx][ny] >= T) {
						visited[nx][ny] = true;
						q.add(new Position(nx, ny));
					}
				}
			}

		}
	}
}




