import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, result;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //알고리즘
        result = 0;
        for (int start = 1; start < N - 1; start++) {
            int[] visited = new int[N];
            int sum = 0;
            dp(start, visited, sum, 0);
        }

        System.out.println(result);
    }

    private static void dp(int cur, int[] visited, int sum, int cnt) {
        if (cnt == N - 2) {
            result = Math.max(result, sum);
            return;
        }
        if (cur == 0 || cur == N - 1) {
            return;
        }

        visited[cur] = 1;
        int left = cur - 1;
        while (visited[left] != 0) {
            left--;
        }
        int right = cur + 1;
        while (visited[right] != 0) {
            right++;
        }
        int newSum = sum + (arr[left] * arr[right]);

        for (int next = 0; next < N; next++) {
            if (visited[next] == 0) {
                //배열 깊은복사 : visited.clone()
                dp(next, visited.clone(), newSum, cnt + 1);
            }
        }
    }
}
