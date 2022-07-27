import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> beads = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            beads.add(Integer.parseInt(st.nextToken()));
        }

        dfs(beads, 0);
        System.out.println(max);
    }

    public static void dfs(List<Integer> beads, int sum) {
        if (beads.size() <= 2) {
            if (max < sum) {
                max = sum;
            }
            return;
        }
        for (int i = 1; i < beads.size() - 1; i++) {
            int removed = beads.remove(i);
            dfs(beads, sum + (beads.get(i - 1) * beads.get(i)));
            beads.add(i, removed);
        }
    }
}
