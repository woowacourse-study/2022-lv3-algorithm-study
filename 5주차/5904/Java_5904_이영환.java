import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int n = Integer.parseInt(bf.readLine());

        final Cycle cycle = findCycleNumber(n);

        final String character = moo(cycle, n);
        System.out.println(character);
    }

    private static String moo(final Cycle cycle, final int n) {
        if (n == 1) {
            return "m";
        }

        if (n <= cycle.calculateBeforeSize()) {
            return moo(new Cycle(cycle.cycle - 1, cycle.calculateBeforeSize()), n);
        } else if (n <= cycle.calculateBeforeSize() + cycle.calculateMiddleLength()) {
            if (n - cycle.calculateBeforeSize() == 1) {
                return "m";
            } else {
                return "o";
            }
        } else {
            return moo(
                    new Cycle(cycle.cycle - 1, cycle.calculateBeforeSize()),
                    n - (cycle.calculateMiddleLength() + cycle.calculateBeforeSize())
            );
        }
    }

    private static Cycle findCycleNumber(final int n) {
        int cycle = 0;
        int size = 3;

        while (size < n) {
            cycle++;
            size = size + (cycle + 3) + size;
        }

        return new Cycle(cycle, size);
    }

    static class Cycle {

        final int cycle;
        final int size;

        public Cycle(final int cycle, final int size) {
            this.cycle = cycle;
            this.size = size;
        }

        public int calculateBeforeSize() {
            return (size - (cycle + 3)) / 2;
        }

        public int calculateMiddleLength() {
            return cycle + 3;
        }
    }
}
