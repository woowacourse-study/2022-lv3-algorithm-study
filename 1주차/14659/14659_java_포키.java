import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        List<Integer> peeks = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxKill = 0;
        for (int i = 0; i < count; i++) {
            int kill = 0;
            for (int j = i + 1; j < count; j++) {
                if (peeks.get(i) < peeks.get(j)) {
                    break;
                }
                kill++;
            }
            if (maxKill < kill) {
                maxKill = kill;
            }
        }
        System.out.println(maxKill);
    }
}
