import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int caseNum = 1;

        while (true) {
            String nextLine = br.readLine();
            if ("0 0 0".equals(nextLine)) {
                break;
            }

            StringTokenizer st = new StringTokenizer(nextLine);
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            int a = V / P;
            int b = V % P;
            if (L < b) {
                b = L;
            }
            int result = a * L + b;
            sb.append("Case ")
                    .append(caseNum)
                    .append(": ")
                    .append(result)
                    .append("\n");

            caseNum++;
        }
        System.out.println(sb);
    }
}
