import static java.util.stream.Collectors.*;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        LinkedList<Integer> numbers = IntStream.rangeClosed(1, n)
            .mapToObj(Integer::valueOf)
            .collect(toCollection(LinkedList::new));

        LinkedList<Integer> result = new LinkedList<>();
        int count = 1;
        while (!numbers.isEmpty()) {
            if (count == k) {
                result.addLast(numbers.removeFirst());
                count = 1;
                continue;
            }

            numbers.addLast(numbers.removeFirst());
            count++;
        }

        String output = result.stream()
            .map(String::valueOf)
            .collect(joining(", "));

        System.out.println("<" + output + ">");
    }
}
