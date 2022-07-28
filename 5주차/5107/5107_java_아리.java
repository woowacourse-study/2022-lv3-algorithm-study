import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testNumber = 1;
        StringBuilder totalResult = new StringBuilder();

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            int result = 0;

            // 마니또 정보 받기
            Map<String, String> manito = new HashMap<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                manito.put(st.nextToken(), st.nextToken());
            }

            // dfs 준비
            List<String> keys = new ArrayList<>(manito.keySet());
            boolean[] visited = new boolean[N];
            Arrays.fill(visited, false);

            for (int i = 0; i < N; i++) {
                // 방문하지 않았다면 dfs 시작
                if (!visited[i]) {

                    visited[i] = true;
                    String startOfCircle = keys.get(i); // 연결고리 시작점

                    String source = manito.get(startOfCircle);
                    int indexOfSource = keys.indexOf(source);

                    while (!visited[indexOfSource]) {

                        String target = manito.get(source);
                        int indexOfTarget = keys.indexOf(target);

                        // 연결고리 완성!
                        if (startOfCircle.equals(target)) {
                            result++;
                            break;
                        }

                        // 아니라면 계속하기
                        source = target;
                        indexOfSource = indexOfTarget;
                    }

                }
            }

            totalResult.append(testNumber++ + " " + result + "\n");
        }

        System.out.println(totalResult);

    }

}
