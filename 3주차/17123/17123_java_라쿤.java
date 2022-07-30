import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String input() {
        try {
            return reader.readLine().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        int t = Integer.parseInt(input());

        for (int i = 0; i < t; i++) {
            String[] temp = input().split(" ");
            int n = Integer.parseInt(temp[0]);
            int m = Integer.parseInt(temp[1]);

            int[][] table = new int[n][];
            for (int j = 0; j < n; j++) {
                table[j] = Arrays.stream(input().split(" "))
                        .mapToInt(Integer :: parseInt)
                        .toArray();
            }

            for (int j = 0; j < m; j++) {
                int[] operation = Arrays.stream(input().split(" "))
                        .mapToInt(Integer :: parseInt)
                        .toArray();
                int r1 = operation[0];
                int c1 = operation[1];
                int r2 = operation[2];
                int c2 = operation[3];
                int v = operation[4];
                for (int k = r1-1; k < r2; k++) {
                    for (int l = c1 - 1; l < c2; l++) {
                        table[k][l] += v;
                    }
                }
            }

            int[] rowSum = new int[n];
            int[] colSum = new int[n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    rowSum[j] += table[j][k];
                    colSum[k] += table[j][k];
                }
            }

            for (int j = 0; j < n; j++) {
                System.out.print(rowSum[j] + " ");
            }
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(colSum[j] + " ");
            }
            System.out.println();
        }
    }
}
