import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

class Main17362 {

    final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int number = Integer.parseInt(reader.readLine());

        final Finger finger = Finger.from(number);

        System.out.println(finger.getNumber());
    }

    enum Finger {
        ONE(1, number -> number % 8 == 1),
        TWO(2, number -> number % 8 == 2 || number % 8 == 0),
        THREE(3, number -> number % 4 == 3),
        FOUR(4, number -> number % 8 == 4 || number % 8 == 6),
        FIVE(5, number -> number % 8 == 5);

        private final int number;
        private final Predicate<Integer> predicate;

        Finger(int number, Predicate<Integer> predicate) {
            this.number = number;
            this.predicate = predicate;
        }

        public static Finger from(int number) {
            return Arrays.stream(Finger.values())
                    .filter(it -> it.predicate.test(number))
                    .findAny()
                    .orElseThrow(IllegalArgumentException::new);
        }

        public int getNumber() {
            return number;
        }
    }
}
