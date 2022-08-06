import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long answer = 0;

        Stack<Integer> heights = new Stack<>();
        for (int i = 0; i < N; i++) {
            final int height = Integer.parseInt(br.readLine());

            // 현재 건물을 볼 수 없으면 제거
            while (!heights.isEmpty() && heights.peek() <= height) {
                heights.pop();
            }

            answer += heights.size(); // 현재 건물을 볼 수 있는 경비원 수
            heights.push(height);
        }

        bw.write(Long.toString(answer));
        bw.flush();
    }
}
