import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer> marbles = new ArrayList<>();

        final StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            marbles.add(Integer.parseInt(st.nextToken()));
        }

        getEnergy(marbles, 0);
        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static void getEnergy(final List<Integer> marbles, final int sum) {
        if (marbles.size() == 2) {
            max = Math.max(max, sum);
        }

        for (int i = 1; i < marbles.size() - 1; i++) {
            int energy = marbles.get(i - 1) * marbles.get(i + 1);
            int removed = marbles.remove(i);
            getEnergy(marbles, sum + energy);
            marbles.add(i, removed);
        }
    }
}
