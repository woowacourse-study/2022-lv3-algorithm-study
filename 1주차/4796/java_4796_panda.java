package algorithm_study.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class java_4796_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int caseNumber = 0;
        while (true) {
            String nextLine = br.readLine();
            if (nextLine.equals("0 0 0")) {
                break;
            }
            caseNumber++;
            StringTokenizer st = new StringTokenizer(nextLine);
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            int answer;
            if (V % P >= L) {
                answer = L * (V / P + 1);
            } else {
                answer = L * (V / P) + V % P;
            }
            sb.append("Case ").append(caseNumber).append(": ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
