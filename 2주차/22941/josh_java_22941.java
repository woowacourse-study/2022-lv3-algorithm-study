import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class josh_java_22941 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        long playerHp = Long.parseLong(inputs[0]);
        long playerAtk = Long.parseLong(inputs[1]);
        long monsterHp = Long.parseLong(inputs[2]);
        long monsterAtk = Long.parseLong(inputs[3]);
        inputs = br.readLine().split(" ");
        long skillActivateCondition = Long.parseLong(inputs[0]);
        long additionalHp = Long.parseLong(inputs[1]);

        long cycle = playerHp / monsterAtk;
        if (playerHp % monsterAtk != 0L) {
            cycle += 1L;
        }

        long monsterBeforeDieHp = monsterHp % playerAtk;
        if (monsterBeforeDieHp == 0L && playerAtk <= skillActivateCondition) {
            monsterHp += additionalHp;
        } else if (monsterBeforeDieHp != 0L && monsterBeforeDieHp <= skillActivateCondition) {
            monsterHp += additionalHp;
        }

        long maxDamage = cycle * playerAtk;
        if (maxDamage >= monsterHp) {
            System.out.println("Victory!");
        } else {
            System.out.println("gg");
        }
    }
}
