import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Main11866 {

    final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final String[] inputs = reader.readLine().split(" ");

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= Integer.parseInt(inputs[0]); i++) {
            queue.add(i);
        }

        int count = Integer.parseInt(inputs[1]);

        System.out.print("<");

        while(queue.size() > 1) {
            for (int i = 0; i < count - 1; i++) {
                final Integer buffer = queue.poll();
                queue.add(buffer);
            }

            System.out.print(queue.poll() + ", ");
        }

        System.out.print(queue.poll() + ">");
    }
}
