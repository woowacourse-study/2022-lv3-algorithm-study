import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String input() {
        try {
            return reader.readLine().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String[] datas = input().split(" ");
        BigInteger heroHp = BigInteger.valueOf(Long.parseLong(datas[0]));
        BigInteger heroAtk = BigInteger.valueOf(Long.parseLong(datas[1]));
        BigInteger devilHp = BigInteger.valueOf(Long.parseLong(datas[2]));
        BigInteger devilAtk = BigInteger.valueOf(Long.parseLong(datas[3]));

        datas = input().split(" ");
        BigInteger devilSkillMoment = BigInteger.valueOf(Long.parseLong(datas[0]));
        BigInteger devilSkillEffect = BigInteger.valueOf(Long.parseLong(datas[1]));

        // devilSkillMoment까지의 공격횟수
        BigInteger midAtkCount = devilHp.subtract(devilSkillMoment).divide(heroAtk);
        if (devilHp.subtract(devilSkillMoment).mod(heroAtk).intValue() != 0) {
            midAtkCount = midAtkCount.add(BigInteger.ONE);
        }

        BigInteger devilMidAtk = devilAtk.multiply(midAtkCount);
        BigInteger destHeroHp = heroHp.subtract(devilMidAtk);

        // devil의 체력이 devilSkillMoment 이하가 되는 순간 hero와 devil의 체력
        BigInteger heroMidAtk = heroAtk.multiply(midAtkCount);
        BigInteger destDevilHp = devilHp.subtract(heroMidAtk);

        if (destHeroHp.add(devilAtk).compareTo(BigInteger.ZERO) >= 0 && destDevilHp.compareTo(BigInteger.ZERO) <= 0) {
            System.out.println("Victory!");
            return;
        }

        // 처음부터 devilHp에 스킬 효과 적용
        devilHp = devilHp.add(devilSkillEffect);

        // 이분 탐색 진행
        long left = 0;
        long right = 100000000000L;
        long mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            BigInteger devilDamage = devilAtk.multiply(BigInteger.valueOf(mid));
            BigInteger heroDamage = heroAtk.multiply(BigInteger.valueOf(mid));

            BigInteger leftHeroHp = heroHp.subtract(devilDamage);
            BigInteger leftDevilHp = devilHp.subtract(heroDamage);

            if (leftHeroHp.compareTo(BigInteger.ZERO) <= 0 && leftDevilHp.compareTo(BigInteger.ZERO) > 0) {
                System.out.println("gg");
                return;
            }
            if (leftHeroHp.compareTo(devilAtk.negate()) > 0 && leftDevilHp.compareTo(BigInteger.ZERO) <= 0) {
                System.out.println("Victory!");
                return;
            }

            if (leftHeroHp.compareTo(BigInteger.ZERO) <= 0 && leftDevilHp.compareTo(BigInteger.ZERO) <= 0) {
                right = mid - 1;
            }

            if (leftHeroHp.compareTo(BigInteger.ZERO) > 0 && leftDevilHp.compareTo(BigInteger.ZERO) > 0) {
                left = mid + 1;
            }
        }
    }


}
