package boj.p22941;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        long soliderHP = Integer.parseInt(st.nextToken());
        long soliderATK = Integer.parseInt(st.nextToken());
        long devilHP = Integer.parseInt(st.nextToken());
        long devilATK = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long P = Integer.parseInt(st.nextToken());
        long S = Integer.parseInt(st.nextToken());

        long soldierDying = getDying(soliderHP, devilATK);

        long devilDying = getDying(devilHP, soliderATK);

        long tmp = devilHP - (devilDying - 1) * soliderATK;
        if (tmp >= 1 && tmp <= P) {
            devilHP += S;
            devilDying = getDying(devilHP, soliderATK);
        }

        if (devilDying < soldierDying) {
            sb.append("Victory!");
        } else if (devilDying == soldierDying) {
            sb.append("Victory!");
        } else {
            sb.append("gg");
        }

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static long getDying(long HP, long ATK) {
        long dying;
        if (HP % ATK == 0) {
            dying = HP / ATK;
        } else {
            dying = HP / ATK + 1;
        }
        return dying;
    }
}
