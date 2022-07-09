import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static long heroHp;
    private static long heroAtk;
    private static long devilHp;
    private static long devilAtk;
    private static long devilSkillActivePoint;
    private static long devilRecoveryHp;

    public static void main(String[] args) throws IOException {
        inputStatus();
        play();
    }

    private static void inputStatus() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        heroHp = Long.parseLong(st.nextToken());
        heroAtk = Long.parseLong(st.nextToken());
        devilHp = Long.parseLong(st.nextToken());
        devilAtk = Long.parseLong(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        devilSkillActivePoint = Long.parseLong(st.nextToken());
        devilRecoveryHp = Long.parseLong(st.nextToken());

        bf.close();
    }

    private static void play() {
        boolean usedSkill = false;
        while (heroHp > 0 && devilHp > 0) {
            reduceHp();

            // 마왕 회복
            if (!usedSkill && devilHp <= devilSkillActivePoint) {
                devilHp += devilRecoveryHp;
                usedSkill = true;
            }

            // 용사 공격
            devilHp -= heroAtk;
            if (devilHp < 1) {
                System.out.println("Victory!");
                return;
            }

            // 마왕 공격
            heroHp -= devilAtk;
            if (heroHp < 1) {
                System.out.println("gg");
                return;
            }
        }
    }

    private static void reduceHp() {
        long cnt = Math.max(0, Math.min(devilHp / heroAtk - 1, heroHp / devilAtk - 1));
        heroHp -= cnt * devilAtk;
        devilHp -= cnt * heroAtk;
    }
}
