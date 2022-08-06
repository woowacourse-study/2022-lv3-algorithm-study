import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String input() {
        try {
            return reader.readLine().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void dfs(int[][] rices, boolean[][] visited, int[] sequences, int beforeRice, int current) {
        if (current == rices.length) {
            return;
        }

        for (int i = 1; i < rices[current].length; i++) {
            if (rices[current][i] == beforeRice || sequences[rices.length - 1] != -1) {
                continue;
            }

            if (!visited[current][i]) {
                sequences[current] = rices[current][i];
                visited[current][i] = true;
                dfs(rices, visited, sequences, rices[current][i], current + 1);
            }
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(input());
        int[][] rices = new int[n][];

        for (int i = 0; i < n; i++) {
            rices[i] = Arrays.stream(input().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[] sequences = new int[n];
        boolean[][] visited = new boolean[n][];
        for (int i = 0; i < n; i++) {
            visited[i] = new boolean[rices[i].length];
        }
        Arrays.fill(sequences, -1);

        dfs(rices, visited, sequences, -1, 0);

        if (sequences[n-1] == -1) {
            System.out.println(-1);
            return;
        }

        for (int sequence : sequences) {
            System.out.println(sequence);
        }
    }
}
