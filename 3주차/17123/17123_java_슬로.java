import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder answer = new StringBuilder();
    static int N, M;
    static int[] rows, cols;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            initialize();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int r1 = Integer.parseInt(st.nextToken()) - 1;
                int c1 = Integer.parseInt(st.nextToken()) - 1;
                int r2 = Integer.parseInt(st.nextToken()) - 1;
                int c2 = Integer.parseInt(st.nextToken()) - 1;
                int value = Integer.parseInt(st.nextToken());
                addValue(r1, c1, r2, c2, value);
            }
            makeAnswer(T);
        }
        System.out.print(answer);
    }

    private static void initialize() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        rows = new int[N];
        cols = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                rows[i] += value;
                cols[j] += value;
            }
        }
    }

    private static void addValue(int r1, int c1, int r2, int c2, int value) {
        for (int r = r1; r <= r2; r++) {
            rows[r] += (c2 - c1 + 1) * value;
        }
        for (int c = c1; c <= c2; c++) {
            cols[c] += (r2 - r1 + 1) * value;
        }
    }

    private static void makeAnswer(int T) {
        for (int i = 0; i < N; i++) {
            answer.append(rows[i]);
            if (i < N - 1) {
                answer.append(" ");
            }
        }
        answer.append("\n");
        for (int i = 0; i < N; i++) {
            answer.append(cols[i]);
            if (i < N - 1) {
                answer.append(" ");
            }
        }
        if (T > 0) {
            answer.append("\n");
        }
    }
}
