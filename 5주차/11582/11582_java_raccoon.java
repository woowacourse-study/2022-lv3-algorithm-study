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

    public static void main(String[] args) {
        int n = Integer.parseInt(input());

        List<Integer> chickens = Arrays.stream(input().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int k = Integer.parseInt(input());

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < n; i = i + (n / k)) {
            List<Integer> temp = new ArrayList<>(chickens.subList(i, i + (n / k)));
            temp.sort(Integer::compareTo);
            results.addAll(temp);
        }

        for (Integer result : results) {
            System.out.print(result + " ");
        }
    }
}
