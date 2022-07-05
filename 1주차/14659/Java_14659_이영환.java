import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final int participantCount = Integer.parseInt(scanner.nextLine());
        final String[] rawHanjoHeights = scanner.nextLine().split(" ");
        final Hanjos hanjos = Hanjos.of(participantCount, rawHanjoHeights);
        System.out.println(hanjos.getMaxKillCount());
    }

    static class Hanjo {

        private final int height;

        public Hanjo(final int height) {
            this.height = height;
        }

        public boolean isKillable(final Hanjo hanjo) {
            return this.height > hanjo.height;
        }

        public boolean isStopAttack(final Hanjo hanjo) {
            return hanjo.height > this.height;
        }
    }

    static class Hanjos {

        private final List<Hanjo> values;

        private Hanjos(final List<Hanjo> values) {
            this.values = values;
        }

        public static Hanjos of(final int participantCount, final String... rawHeights) {
            validateCount(participantCount, rawHeights);
            final List<Hanjo> participants = new ArrayList<>();
            for (int i = 0; i < participantCount; i++) {
                final int rawHeight = Integer.parseInt(rawHeights[i]);
                participants.add(new Hanjo(rawHeight));
            }

            return new Hanjos(participants);
        }

        private static void validateCount(final int participantCount, final String[] rawHeights) {
            if (participantCount != rawHeights.length) {
                throw new IllegalArgumentException("참가자 수랑 입력된 봉우리 수랑 다름!");
            }
        }

        public int getMaxKillCount() {
            int max = 0;
            int cursor = 0;
            int cursorMax = 0;

            for (int i = 0; i < values.size(); i++) {
                final Hanjo hanjo = values.get(cursor);
                final Hanjo nextHanjo = values.get(i);

                if (hanjo.isStopAttack(nextHanjo)) {
                    cursor = i;
                    cursorMax = 0;
                }

                if (hanjo.isKillable(nextHanjo)) {
                    cursorMax++;
                    if (cursorMax > max) {
                        max = cursorMax;
                    }
                }
            }

            return max;
        }
    }
}
