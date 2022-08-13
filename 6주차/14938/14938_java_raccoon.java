import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX_VALUE = 1000000000;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String input() {
        try {
            return reader.readLine().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String[] temp = input().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        int r = Integer.parseInt(temp[2]);

        int[] items = Arrays.stream(input().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            distance[i][i] = 0;
        }

        for (int i = 0; i < r; i++) {
            StringTokenizer tokenizer = new StringTokenizer(input());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int l = Integer.parseInt(tokenizer.nextToken());

            distance[a-1][b-1] = Math.min(distance[a-1][b-1], l);
            distance[b-1][a-1] = Math.min(distance[b-1][a-1], l);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    distance[j][k] = Math.min(distance[j][k], distance[j][i] + distance[i][k]);
                    distance[k][j] = Math.min(distance[k][j], distance[j][k]);
                }
            }
        }
        
        int itemCount = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (distance[i][j] <= m) {
                    count += items[j];
                }
            }
            itemCount = Math.max(itemCount, count);
        }

        System.out.println(itemCount);
    }
}

