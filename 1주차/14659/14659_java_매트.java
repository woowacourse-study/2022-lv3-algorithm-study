import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (numbers.get(i) < numbers.get(j)) {
                    break;
                }
                
                count++;
            }
            max = Math.max(count, max);
        }

        System.out.println(max);
    }
}