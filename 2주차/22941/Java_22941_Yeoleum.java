import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_22941_Yeoleum {

    private final static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine(), " ");
        long soldierHp = Integer.parseInt(st.nextToken());
        long soldierATK = Integer.parseInt(st.nextToken());
        long devilHp = Integer.parseInt(st.nextToken());
        long devilATK = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(r.readLine(), " ");
        int p = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        devilHp = healDevil(soldierATK, devilHp, p, s);

        final double soldierAttackCount = calculateAttackCount(soldierHp, devilATK);
        final double devilAttackCount = calculateAttackCount(devilHp, soldierATK);

        printResultMessage(soldierAttackCount, devilAttackCount);
    }

    private static long healDevil(long soldierATK, long devilHp, int p, int s) {
        final long i = (devilHp - p) % soldierATK;
        if(checkHeal(soldierATK, p, i)){
            devilHp += s;
        }
        return devilHp;
    }

    private static boolean checkHeal(long soldierATK, int p, long i) {
        return i == 0 || i + p > soldierATK;
    }

    private static double calculateAttackCount(double soldierHp, double devilATK) {
        return Math.ceil(soldierHp / devilATK);
    }

    private static void printResultMessage(double soldierAttackCount, double devilAttackCount) {
        if(soldierAttackCount >= devilAttackCount){
            System.out.println("Victory");
            return;
        }
        System.out.println("gg");
    }
}
