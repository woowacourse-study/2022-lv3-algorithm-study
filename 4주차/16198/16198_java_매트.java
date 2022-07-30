import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int power;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Integer> marbles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            marbles.add(scanner.nextInt());
        }

        dfs(n, marbles, 0);
        System.out.println(power);
    }

    private static void dfs(int n, List<Integer> marbles, int sum) {
        if (n == 2) {
            power = Math.max(power, sum);
            return;
        }

        for (int i = 1; i < marbles.size() - 1; i++) {
            int s = marbles.get(i - 1) * marbles.get(i + 1);
            int marble = marbles.remove(i);
            dfs(n -  1, marbles, sum + s);
            marbles.add(i, marble);
        }
    }
}
