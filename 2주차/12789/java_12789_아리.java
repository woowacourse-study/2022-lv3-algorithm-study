import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> line = new LinkedList<>();
        Stack<Integer> space = new Stack<>();

        for (int i = 0; i < count; i++) {
            line.add(Integer.parseInt(st.nextToken()));
        }

        int num = 1;

        while (true) {
            if (!line.isEmpty() && line.peek() == num) { // 다음사람이 대기줄에 있는 경우
                line.poll();
                num++;
            } else if (!space.isEmpty() && space.peek() == num) { // 다음사람이 대기 공간에 있는 경우
                space.pop();
                num++;
            } else if (!line.isEmpty()) { // 다음사람은 아니지만 대기줄에 사람이 더 있는 경우
                space.push(line.poll());
            } else {
                break;
            }
        }

        System.out.println((num == count + 1) ? "Nice" : "Sad");
    }

}
