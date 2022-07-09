import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer n = scanner.nextInt();

        if (n < 6) {
            System.out.println(n);
        } else {
            Finger.getFinger(n % 8).result();
        }
    }
}

enum Finger {
    ONE(1, r -> r == 1),
    TWO(2, r -> r == 0 || r == 2),
    THREE(3, r -> r == 7 || r == 3),
    FOUR(4, r -> r == 6 || r == 4),
    FIVE(5, r -> r == 5);

    private final Integer result;
    private final Predicate<Integer> condition;

    Finger(Integer result, Predicate<Integer> condition) {
        this.result = result;
        this.condition = condition;
    }

    static Finger getFinger(Integer r) {
        return Arrays.stream(values())
                .filter(f -> f.condition.test(r))
                .findAny()
                .get();
    }

    void result() {
        System.out.println(result);
    }
}
