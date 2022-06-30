import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int caseNum = 1;

        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        while (!isFinal(L, P, V)) {
            int a = V / P;
            int b = V % P;
            if (L < b) {
                b = L;
            }
            int result = a * L + b;
            sb.append("Case " + caseNum + ": " + result + "\n");

            st = new StringTokenizer(br.readLine());
            caseNum++;

            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
        }
        System.out.println(sb);
    }

    public static boolean isFinal(int L, int P, int V) {
        return L == 0 && P == 0 && V == 0;
    }
}
