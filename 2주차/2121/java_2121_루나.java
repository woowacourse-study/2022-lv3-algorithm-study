import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main {
	static class Position {
		int x, y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Position position = (Position)o;
			return x == position.x && y == position.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}

	static Set<Position> positions = new HashSet<>();
	static int X_DIS, Y_DIS;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] rectangleInfo = br.readLine().split(" ");
		X_DIS = Integer.parseInt(rectangleInfo[0]);
		Y_DIS = Integer.parseInt(rectangleInfo[1]);

		int result = 0;

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split((" "));
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			positions.add(new Position(x, y));
		}

		for (Position position : positions) {
			if (checkRectangle(position.x, position.y)) {
				result++;
			}
		}

		System.out.println(result);
	}

	private static boolean checkRectangle(int x, int y) {
		return checkContaining(x + X_DIS, y) && checkContaining(x, y + Y_DIS) && checkContaining(x + X_DIS, y + Y_DIS);
	}

	private static boolean checkContaining(int x, int y) {
		return positions.contains(new Position(x, y));
	}
}
