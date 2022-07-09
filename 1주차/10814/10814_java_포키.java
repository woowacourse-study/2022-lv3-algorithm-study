import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        List<String> inputs = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            inputs.add(scanner.nextLine());
        }
        inputs.stream()
                .sorted(Comparator.comparingInt(input -> Integer.parseInt(input.split(" ")[0])))
                .forEach(System.out::println);
    }
}
