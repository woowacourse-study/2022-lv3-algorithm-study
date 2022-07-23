import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader BR;
    private static StringTokenizer ST;
    private static StringBuilder RESULT = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BR = new BufferedReader(new InputStreamReader(System.in));
        int testCase = parseInt(BR.readLine());

        for (int i = 0; i < testCase; i++) {
            play();
        }
        System.out.println(new String(RESULT));
    }

    private static void play() throws IOException {
        ST = new StringTokenizer(BR.readLine());
        int n = Integer.parseInt(ST.nextToken()), m = Integer.parseInt(ST.nextToken());

        int[][] matrix = getMatrix(n);
        operate(m, matrix);
        show(n, matrix);
    }

    private static int[][] getMatrix(int n) throws IOException {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            ST = new StringTokenizer(BR.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(ST.nextToken());
            }
        }
        return matrix;
    }

    private static void operate(int m, int[][] matrix) throws IOException {
        for (int i = 0; i < m; i++) {
            ST = new StringTokenizer(BR.readLine());
            int r1 = Integer.parseInt(ST.nextToken());
            int c1 = Integer.parseInt(ST.nextToken());
            int r2 = Integer.parseInt(ST.nextToken());
            int c2 = Integer.parseInt(ST.nextToken());
            int v = Integer.parseInt(ST.nextToken());

            for (int r = r1 - 1; r <= r2 - 1; r++) {
                for (int c = c1 - 1; c <= c2 - 1; c++) {
                    matrix[r][c] += v;
                }
            }
        }
    }

    private static void show(int n, int[][] matrix) {
        for (int r = 0; r < n; r++) {
            int sum = 0;
            for (int c = 0; c < n; c++) {
                sum += matrix[r][c];
            }
            RESULT.append(sum).append(" ");
        }
        RESULT.append("\n");

        for (int c = 0; c < n; c++) {
            int sum = 0;
            for (int r = 0; r < n; r++) {
                sum += matrix[r][c];
            }
            RESULT.append(sum).append(" ");
        }
        RESULT.append("\n");
    }
}
