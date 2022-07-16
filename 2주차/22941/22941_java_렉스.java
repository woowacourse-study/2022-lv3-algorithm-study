import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int knightHP = Integer.parseInt(st.nextToken());
        int knightATK = Integer.parseInt(st.nextToken());
        long devilHP = Integer.parseInt(st.nextToken());
        int devilATK = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        long remainder = devilHP % knightATK;
        if ((1 <= remainder && remainder <= P) || (knightATK == 1)) { // 추가 스킬을 발동할 수 있는지 체크 및 스킬 미리 가동
            devilHP += S;
        }

        // 각각 죽기까지 걸리는 턴 계산
        int turnsUntilKnightDie = (int) Math.ceil(knightHP / (float) devilATK);
        long turnsUntilDevilDie = (long) Math.ceil(devilHP / (double) knightATK);

        // 턴 비교 후, 결과 도출
        if (turnsUntilDevilDie <= turnsUntilKnightDie) {
            System.out.println("Victory!");
        } else {
            System.out.println("gg");
        }
    }
}
