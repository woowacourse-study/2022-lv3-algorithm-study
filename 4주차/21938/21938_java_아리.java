import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] screen = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                screen[i][j] = (Integer.parseInt(st.nextToken())
                    + Integer.parseInt(st.nextToken())
                    + Integer.parseInt(st.nextToken())) / 3;
            }
        }

        int T = Integer.parseInt(br.readLine());
        int[][] dfsArr = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상하좌우
        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 물체 발견!
                if (screen[i][j] >= T) {
                    result++;

                    // dfs
                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[] {i, j});
                    screen[i][j] = -1;

                    while (!stack.isEmpty()) {
                        int[] target = stack.pop();

                        for (int[] arr : dfsArr) {
                            int x = target[0] + arr[0];
                            int y = target[1] + arr[1];
                            if (x >= 0 && x < N && y >= 0 && y < M && screen[x][y] >= T) {
                                stack.push(new int[] {x, y});
                                screen[x][y] = -1;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(result);

    }

}
