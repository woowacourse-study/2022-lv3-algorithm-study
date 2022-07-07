package algorithm_study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class java_22941_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long heroHP = Integer.parseInt(st.nextToken());
        long heroATK = Integer.parseInt(st.nextToken());
        long demonHP = Integer.parseInt(st.nextToken());
        long demonATK = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long P = Integer.parseInt(st.nextToken());
        long S = Integer.parseInt(st.nextToken());

        if ((demonHP - P) % heroATK == 0 || (demonHP - P) % heroATK + P > heroATK) {
            demonHP += S;
        }

        long demonDeathCount = (long)Math.ceil((double)demonHP / (double)heroATK);
        long heroDeathCount = (long)Math.ceil((double)heroHP / (double)demonATK);

        String result;
        if (demonDeathCount > heroDeathCount) {
            result = "gg";
        } else {
            result = "Victory!";
        }
        System.out.println(demonDeathCount <= heroDeathCount ? "Victory!" : "gg");
    }
}
