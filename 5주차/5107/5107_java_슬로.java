import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int index = 1;
        while (true) {
            int total = 0;
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String from = st.nextToken();
                String to = st.nextToken();
                map.put(from, to);
            }
            Set<String> used = new HashSet<>();
            for (String key : map.keySet()) {
                if (!used.contains(key)) {
                    find(key, used, map);
                    total++;
                }
            }
            answer.append(index++)
                    .append(" ")
                    .append(total)
                    .append("\n");
        }
        System.out.print(answer);
    }

    private static void find(String key, Set<String> used, Map<String, String> map) {
        if (used.contains(key)) {
            return;
        }
        used.add(key);
        find(map.get(key), used, map);
    }
}

