import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Java_17123_Yeoleum {

    private static final BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(r.readLine());
        for (int c = 0; c < t; c++) {
            StringTokenizer st1 = new StringTokenizer(r.readLine(), " ");
            int n = Integer.parseInt(st1.nextToken());
            int m = Integer.parseInt(st1.nextToken());

            int[][] graph = setGraph(n);

            List<Integer> sumRow = new ArrayList<>();
            List<Integer> sumColumn = new ArrayList<>();

            sumOfRowsAndColumns(n, graph, sumRow, sumColumn);

            for (int i = 0; i < m; i++) {
                StringTokenizer st3 = new StringTokenizer(r.readLine(), " ");
                int y1 = Integer.parseInt(st3.nextToken());
                int x1 = Integer.parseInt(st3.nextToken());
                int y2 = Integer.parseInt(st3.nextToken());
                int x2 = Integer.parseInt(st3.nextToken());
                int v = Integer.parseInt(st3.nextToken());

                for (int j = x1 - 1; j < x1 + (x2 - x1); j++) {
                    sumColumn.set(j, sumColumn.get(j) + (v * (y2 - y1 + 1)));
                }

                for (int j = y1 - 1; j < y1 + (y2 - y1); j++) {
                    sumRow.set(j, sumRow.get(j) + (v * (x2 - x1 + 1)));
                }
            }

            System.out.println(sumRow.toString().replace("[","").replace("]","").replace(",", ""));
            System.out.println(sumColumn.toString().replace("[","").replace("]","").replace(",", ""));
        }
    }

    private static int[][] setGraph(int n) throws IOException {
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(r.readLine(), " ");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        return graph;
    }

    private static void sumOfRowsAndColumns(int n, int[][] graph, List<Integer> sumX, List<Integer> sumY) {
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += graph[i][j];
            }
            sumX.add(sum);
        }

        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += graph[i][j];
            }
            sumY.add(sum);
        }
    }
}
