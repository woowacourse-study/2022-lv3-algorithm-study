import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final String[] firstInput = bf.readLine().split("\\s+");
        final String[] secondInput = bf.readLine().split("\\s+");
        final Fighter theBrave = TheBrave.of(firstInput[0], firstInput[1], "Victory!");
        final Fighter kingOfSuwon = KingOfSuwon.of(
                firstInput[2],
                firstInput[3],
                "gg",
                secondInput[0],
                secondInput[1]
        );

        final Match match = new Match(theBrave, kingOfSuwon);

        System.out.println(match.getWinnerMessage());
    }

    static class Match {

        private final Fighter firstStriker;
        private final Fighter secondStriker;

        public Match(final Fighter firstStriker, final Fighter secondStriker) {
            this.firstStriker = firstStriker;
            this.secondStriker = secondStriker;
        }

        public String getWinnerMessage() {
            final long firstHitCut = firstStriker.calculateHitCut(secondStriker.getAtk());
            final long secondHitCut = secondStriker.calculateHitCut(firstStriker.getAtk());

            if (firstHitCut >= secondHitCut) {
                return firstStriker.getWinningMessage();
            }
            return secondStriker.getWinningMessage();
        }
    }

    interface Fighter {
        long calculateHitCut(final long enemyAtk);

        long getAtk();

        String getWinningMessage();
    }

    static abstract class AbstractFighter implements Fighter {

        protected final long hp;
        protected final long atk;
        protected final String winningMessage;

        public AbstractFighter(final long hp, final long atk, final String winningMessage) {
            this.hp = hp;
            this.atk = atk;
            this.winningMessage = winningMessage;
        }

        @Override
        public long getAtk() {
            return atk;
        }

        @Override
        public String getWinningMessage() {
            return winningMessage;
        }
    }

    static class TheBrave extends AbstractFighter {

        public TheBrave(final long hp, final long atk, final String winningMessage) {
            super(hp, atk, winningMessage);
        }

        public static TheBrave of(final String rawHp, final String rawAtk, final String winningMessage) {
            return new TheBrave(Long.parseLong(rawHp), Long.parseLong(rawAtk), winningMessage);
        }

        @Override
        public long calculateHitCut(final long enemyAtk) {
            if (hp % enemyAtk == 0) {
                return hp / enemyAtk;
            }
            return (hp / enemyAtk) + 1;
        }
    }

    static class KingOfSuwon extends AbstractFighter {

        private final long recoverHp;
        private final long recoverAmount;

        public KingOfSuwon(final long hp, final long atk, final String winningMessage, final long recoverHp,
                           final long recoverAmount) {
            super(hp, atk, winningMessage);
            this.recoverHp = recoverHp;
            this.recoverAmount = recoverAmount;
        }

        public static KingOfSuwon of(final String rawHp,
                                     final String rawAtk,
                                     final String winningMessage,
                                     final String rawRecoverHp,
                                     final String rawRecoverAmount) {

            return new KingOfSuwon(
                    Long.parseLong(rawHp),
                    Long.parseLong(rawAtk),
                    winningMessage,
                    Long.parseLong(rawRecoverHp),
                    Long.parseLong(rawRecoverAmount)
            );
        }

        @Override
        public long calculateHitCut(final long enemyAtk) {
            long realHp = hp;
            if (canRecover(enemyAtk)) {
                realHp += recoverAmount;
            }

            if (realHp % enemyAtk == 0) {
                return realHp / enemyAtk;
            }
            return (realHp / enemyAtk) + 1;
        }

        private boolean canRecover(final long enemyAtk) {
            if ((hp - recoverHp) % enemyAtk == 0) {
                return true;
            }
            final long n = (hp - recoverHp) / enemyAtk;
            final long m = hp - (n * enemyAtk);
            return m > enemyAtk;
        }
    }
}
