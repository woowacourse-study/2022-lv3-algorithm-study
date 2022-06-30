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

        int maxMountaintop = numbers.get(0);
        int killCount = 0;
        int killMax = Integer.MIN_VALUE;
        for (int i = 1; i < numbers.size(); i++) {
            if (maxMountaintop < numbers.get(i)) {
                maxMountaintop = numbers.get(i);
                killMax = Math.max(killCount, killMax);
                killCount = 0;
                continue;
            }

            killCount++;
            killMax = Math.max(killCount, killMax);
        }

        System.out.println(killMax);
    }
}
