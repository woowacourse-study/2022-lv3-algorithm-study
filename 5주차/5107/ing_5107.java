import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ing_5107 {
    static int[][] map;
    static int n;
    static int count;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = 1;

        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                return;
            }

            List<String> names = new ArrayList<>();
            map = new int[n][n];
            visited = new boolean[n];
            count = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();

                if (!names.contains(name1)) {
                    names.add(name1);
                }
                if (!names.contains(name2)) {
                    names.add(name2);
                }

                map[names.indexOf(name1)][names.indexOf(name2)] = 1;
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    for (int j = 0; j < n; j++) {
                        if (map[i][j] == 1 && !visited[j]) {
                            visited[i] = true;
                            solution(j);
                        }
                    }
                }
            }

            System.out.println(testCase + " " + count);
            testCase++;
        }
    }

    static void solution(int x) {
        visited[x] = true;

        for (int i = 0; i < n; i++) {
            if (map[x][i] == 1) {
                if (!visited[i]) {
                    solution(i);
                } else {
                    count++;
                }
                break;
            }
        }
    }
}
