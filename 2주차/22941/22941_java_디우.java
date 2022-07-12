import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main22941 {

    final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int[] info = getInfo();

        final User user = new User(info[0], info[1]);
        final User monster = new User(info[2], info[3]);

        final int[] skill = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int count = 1;

        while (true) {
            // 용사의 공격력만큼 마왕의 체력을 깎습니다.
            monster.attacked(user.getAtk());

            // 마왕의 체력이 0 이하이면 용사가 승리하고 게임이 종료
            if (monster.getHp() <= 0) {
                System.out.println("Victory");
                return;
            }

            // 마왕의 공격력만큼 용사의 체력을 깎습니다.
            user.attacked(monster.getAtk());

            // 용사의 체펵이 0 이하이면 용사가 패배하고 게미이 종료됩니다.
            if (user.getHp() <= 0) {
                System.out.println("gg");
                return;
            }

            // 마왕의 체력이 1 이상 P 이하일 경우 S만큼의 체력을 회복합니다.
            if (monster.getHp() >= 1 && monster.getHp() <= skill[0] && count > 0) {
                monster.hill(skill[1]);
                count = 0;
            }

        }
    }

    private static int[] getInfo() throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    static class User {
        private int hp;
        private final int atk;

        public User(final int hp, final int atk) {
            this.hp = hp;
            this.atk = atk;
        }

        public int getHp() {
            return hp;
        }

        public int getAtk() {
            return atk;
        }

        public void attacked(final int atk) {
            this.hp = this.hp - atk;
        }

        public void hill(final int recovery) {
            this.hp = this.hp + recovery;
        }
    }
}
