import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int startPosition = 0;
        while (!list.isEmpty()) {
            if (startPosition == list.size())
                startPosition = 0;

            int deletePosition = startPosition + K - 1;

            if (list.size() < deletePosition) {
                deletePosition = deletePosition % list.size();
            }
            if (deletePosition >= list.size()) {
                deletePosition -= list.size();
            }

            int removed = list.remove(deletePosition);
            startPosition = deletePosition;
            sb.append(removed)
                    .append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        System.out.println(sb);
    }
}
