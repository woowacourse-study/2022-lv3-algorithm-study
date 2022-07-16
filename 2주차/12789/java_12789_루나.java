import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static String SUCCESS = "Nice";
	static String FAIL = "Sad";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		int count = 1;

		Stack<Integer> firstLine = new Stack<>();
		Stack<Integer> secondLine = new Stack<>();

		for (int i = input.length - 1; i >= 0; i--) {
			firstLine.push(Integer.parseInt(input[i]));
		}

		if (checkCanEatSnack(N, count, firstLine, secondLine)) {
			System.out.println(SUCCESS);
		} else {
			System.out.println(FAIL);
		}
	}

	private static boolean checkCanEatSnack(int N, int count, Stack<Integer> firstLine, Stack<Integer> secondLine) {
		while (count < N + 1) {
			if (!firstLine.isEmpty() && firstLine.peek() == count) {
				firstLine.pop();
				count++;
			} else if (!secondLine.isEmpty() && secondLine.peek() == count) {
				secondLine.pop();
				count++;
			} else if (!firstLine.isEmpty()) {
				secondLine.push(firstLine.pop());
			} else {
				return false;
			}
		}
		return true;
	}
}
