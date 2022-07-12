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
        int total = Integer.parseInt(st.nextToken());
        int interval = Integer.parseInt(st.nextToken()) - 1;

        List<Integer> members = new ArrayList<>();
        for (int i = 1; i <= total; i++) {
            members.add(i);
        }

        List<Integer> orders = new ArrayList<>();
        int index = interval;
        while (true) {
            orders.add(members.remove(index));

            if (members.isEmpty()) {
                break;
            }

            index += interval;
            while (index >= members.size()) {
                index -= members.size();
            }
        }

        System.out.print("<");
        for (int i = 0; i < orders.size(); i++) {
            System.out.print(orders.get(i));
            if (i != orders.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}
