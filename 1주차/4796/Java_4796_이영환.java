import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final List<Lpv> lpvs = inputCycle(new ArrayList<>());

        for (int i = 0; i < lpvs.size() ; i++) {
            final Lpv lpv = lpvs.get(i);
            System.out.println("Case " + (i + 1) + ": " + lpv.calculateAvailableDays());
        }
    }

    private static List<Lpv> inputCycle(final List<Lpv> lpvs) {
        final Lpv lpv = Lpv.of(scanner.nextLine());

        if (lpv.isEndFlag()) {
            return lpvs;
        }
        lpvs.add(lpv);
        return inputCycle(lpvs);
    }

    static class Lpv {

        private final int l;
        private final int p;
        private final int v;

        private Lpv(final int l, final int p, final int v) {
            this.l = l;
            this.p = p;
            this.v = v;
        }

        public static Lpv of(final String rawLpv) {
            final String[] lpv = rawLpv.split("\\s+");
            final int l = Integer.parseInt(lpv[0]);
            final int p = Integer.parseInt(lpv[1]);
            final int v = Integer.parseInt(lpv[2]);
            return new Lpv(l, p, v);
        }

        public boolean isEndFlag() {
            return l == 0 && p == 0 && v == 0;
        }

        public int calculateAvailableDays() {
            int days = 0;

            days += (v / p) * l;

            if (v % p < l) {
                return days + v % p;
            }
            return days + l;
        }
    }
}
