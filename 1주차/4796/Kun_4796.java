import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kun_4796 {
    static int maxUse(int l, int p, int v) {
        int maxday = 0;
        int enoughday = v / p * l;
        int remainday = v - v / p * p;

        if (l <= remainday) {
            maxday = enoughday + l;
        } else {
            maxday = enoughday + remainday;
        }

        return maxday;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int l, p, v;
        int index = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            if (l == 0 && p == 0 && v == 0) {
                break;
            }

            sb.append("Case ").append(index++).append(": ").append(maxUse(l, p, v)).append("\n");
        }
        ;
        System.out.println(sb);
    }
}
