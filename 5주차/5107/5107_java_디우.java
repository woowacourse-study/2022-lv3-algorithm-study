import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main5107 {

    final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int testCase = 1;

        while (true) {
            final int count = Integer.parseInt(reader.readLine());
            
            if (count == 0) {
                break;
            }

            Map<String, String> manitto = new HashMap<>();
            boolean[] visited = new boolean[count];

            for (int i = 0; i < count; i++) {
                final String[] link = reader.readLine().split(" ");
                manitto.put(link[0], link[1]);
                visited[i] = false;
            }

            final List<String> senders = new ArrayList<>(manitto.keySet());

            int result = 0;
            for (int i = 0; i < count; i++) {
                if (!visited[i]) {
                    visited[i] = true;

                    String sender = senders.get(i);
                    String receiver = manitto.get(sender);

                    int index = senders.indexOf(receiver);
                    while (!visited[index]) {
                        final String buf = manitto.get(receiver);

                        if (sender.equals(buf)) {
                            visited[index] = true;
                            result ++;
                            break;
                        }

                        index = senders.indexOf(receiver);
                        receiver = buf;
                    }
                }
            }

            System.out.println(testCase + " " + result);
            testCase++;
        }
    }
}
