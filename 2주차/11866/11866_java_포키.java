import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        StringBuilder result = new StringBuilder().append("<");
        int i = 1;
        while (true) {
            int removed = list.removeFirst();
            if (i == k) {
                result.append(removed);
                if (list.isEmpty()) {
                    result.append(">");
                    break;
                }
                result.append(", ");
                i = 1;
            } else {
                list.addLast(removed);
                i++;
            }
        }
        System.out.println(result);
    }
}
