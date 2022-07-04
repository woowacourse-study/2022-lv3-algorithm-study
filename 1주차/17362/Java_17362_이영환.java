import java.util.List;
import java.util.Scanner;

public class Main {

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final InputNumber inputNumber = new InputNumber(scanner.nextInt());

        System.out.println(inputNumber.getFingerNumber());
    }

    static class InputNumber {
        private static final List<Integer> fingerNumberCycle = List.of(2, 1, 2, 3, 4, 5, 4, 3);
        private static final int CYCLE_LENGTH = 8;

        private final int value;

        public InputNumber(final int value) {
            this.value = value;
        }

        public int getFingerNumber() {
            return fingerNumberCycle.get(value % CYCLE_LENGTH);
        }
    }
}
