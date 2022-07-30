import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Integer> numbers = new ArrayList<>();
    static int max = 0;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt());
        }

        dfs(0);

        System.out.println(max);
    }

    private static void dfs(int sum) {
        if (numbers.size() == 2) {
            if (sum > max) {
                max = sum;
            }
        }

        for (int i = 1; i < numbers.size() - 1; i++) {
            int number = numbers.get(i);
            int energy = numbers.get(i - 1) * numbers.get(i + 1);
            numbers.remove(i);
            dfs(sum + energy);
            numbers.add(i, number);
        }
    }
}
