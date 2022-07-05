import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String input() {
        try {
            return br.readLine().trim();
        } catch (Exception e) {}
        return null;
    }

    public static void main(String[] args) {
        String[] datas = input().split(" ");
        int n = Integer.parseInt(datas[0]);
        int k = Integer.parseInt(datas[1]);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n+1; i++) {
            queue.offer(i);
        }

        StringBuffer sb = new StringBuffer();
        while (!queue.isEmpty()) {
            for (int i = 0; i < k-1; i++) {
                queue.offer(queue.poll());
            }
            sb.append(queue.poll());
            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }

        String result = String.join(", ", sb.toString());
        result = "<" + result + ">";

        System.out.println(result);
    }
}
