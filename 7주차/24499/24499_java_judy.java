package PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class blobyum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> appleFie = new ArrayList<>();
        while (st.hasMoreTokens()) {
            appleFie.add(Integer.valueOf(st.nextToken()));
        }
        for (int i = 0; i < k - 1; i++) {
            appleFie.add(appleFie.get(i));
        }

        // 애플파이들을 n+1까지 돌면서 k구간만큼 중 가장 큰 수를 반환한다.
        int maxFie = 0;
        for (int i = 0; i < k; i++) {
            maxFie += appleFie.get(i);
        }

        int appleFies = maxFie;
        for (int i = k; i < n + k - 1; i++) {
            Integer pre = appleFie.get(i - k);
            Integer next = appleFie.get(i);
            appleFies = appleFies - pre + next;
            maxFie = Math.max(maxFie, appleFies);
        }

        System.out.println(maxFie);
    }
}
