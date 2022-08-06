import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int T = 1;

        while (N != 0) {
            Map<String, String> manito = new HashMap<>();
            Map<String, Boolean> visited = new HashMap<>();
            result = 0;


            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String person1 = st.nextToken();
                String person2 = st.nextToken();
                manito.put(person1, person2);
                visited.put(person1, false);
            }

            // 돌면서 연결 고리의 개수 확인.
            for (String person : visited.keySet()) {
                check(manito, visited, person, person);
            }

            // 결과 출력
            System.out.println(T++ + " " + result);
            // 테케 연결고리 개수
            N = Integer.parseInt(br.readLine());
        }
    }

    private static void check(Map<String, String> manito, Map<String, Boolean> visited, String start, String now) {
        if (!visited.get(now)) {
            visited.put(now, true);
            if (manito.get(now).equals(start)){
                result++;
            }else{
                check(manito, visited, start, manito.get(now));
            }
        }
    }
}