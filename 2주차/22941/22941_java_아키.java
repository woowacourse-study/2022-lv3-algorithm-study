import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        long hp1 = Integer.parseInt(inputs[0]);
        long attack1 = Integer.parseInt(inputs[1]);
        long hp2 = Integer.parseInt(inputs[2]);
        long attack2 = Integer.parseInt(inputs[3]);

        inputs = br.readLine().split(" ");
        long p = Integer.parseInt(inputs[0]);
        long s = Integer.parseInt(inputs[1]);

        //알고리즘
        long share1 = hp1 / attack2 - 1;
        long share2 = hp2 / attack1 - 1;

        long min = Math.max(0, Math.min(share1, share2));
        hp1 -= min * attack2;
        hp2 -= min * attack1;
        boolean canHeal = true;
        if (hp2 <= p) {
            hp2 += s;
            canHeal = false;
        }

        while (hp1 > 0 && hp2 > 0) {
            hp2 -= attack1;
            if (hp2 <= 0) {
                System.out.println("Victory!");
                return;
            }

            hp1 -= attack2;
            if (hp1 <= 0) {
                System.out.println("gg");
                return;
            }

            if (canHeal && hp2 <= p) {
                hp2 += s;
                canHeal = false;
            }

            share1 = hp1 / attack2 - 1;
            share2 = hp2 / attack1 - 1;
            min = Math.max(0, Math.min(share1, share2));
            hp1 -= min * attack2;
            hp2 -= min * attack1;
        }
    }
}
