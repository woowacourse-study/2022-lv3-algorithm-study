package algorithm_study.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class java_24393_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int position = 1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0, otherSum=0;
            boolean isOnLeft = position <= 13;
            position = isOnLeft ? position : position - 13;

            boolean isLeftPick = true;
            while (st.hasMoreTokens() && sum < position) {
                isLeftPick = !isLeftPick;
                int pick = Integer.parseInt(st.nextToken());
                if (isOnLeft != isLeftPick) {
                    otherSum += pick;
                } else {
                    sum += pick;
                }
            }
            position += otherSum;
        }
        System.out.println(position);
    }
}
