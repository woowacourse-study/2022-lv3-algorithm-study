import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();
        long totalNumber = 0;
        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            numbers.add(number);
            totalNumber += number;
        }

        long sum = 0;
        for (int i = 0; i < n - 1; i++) {
            int number = numbers.get(i);
            totalNumber -= number;
            // 모든 정수쌍의 합을 MOD로 나눠야 한다.
            // 즉 일반화한 정수쌍들의 합을 MOD로 나누게 되면 총 합을 MOD로 나눈 것과 같다.
            sum = (sum + number * totalNumber) % MOD;
        }

        System.out.println(sum);
    }
}
