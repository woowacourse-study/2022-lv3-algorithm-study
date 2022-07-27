import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static int N;
    private static List<Integer> energyBalls;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        input();
        calculate(0);
        System.out.println(max);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        energyBalls = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        br.close();
    }

    private static void calculate(int sum) {
        if (N <= 2) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            int tempSum = energyBalls.get(i - 1) * energyBalls.get(i + 1);
            int temp = energyBalls.remove(i);
            N--;
            calculate(sum + tempSum);
            energyBalls.add(i, temp);
            N++;
        }
    }
}
