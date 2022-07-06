import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 1 <= n <= 10^9

        int remainder = n % 8;
        Finger finger = Finger.valueOf(remainder);

        System.out.println(finger.getNumber());
    }
}

enum Finger {

    THUMB(1, Set.of(1)),
    INDEX_FINGER(2, Set.of(0, 2)),
    MIDDLE_FINGER(3, Set.of(3, 7)),
    RING_FINGER(4, Set.of(4, 6)),
    PINKY(5, Set.of(5))
    ;

    private final int number;
    private final Set<Integer> remainders;

    Finger(int number, Set<Integer> remainders) {
        this.number = number;
        this.remainders = remainders;
    }

    public static Finger valueOf(int remainder) {
        return Arrays.stream(values())
                .filter(finger -> finger.remainders.contains(remainder))
                .findFirst()
                .get();
    }

    public int getNumber() {
        return number;
    }
}