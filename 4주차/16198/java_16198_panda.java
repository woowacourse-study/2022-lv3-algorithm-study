package algorithm_study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class java_16198_panda {
    static List<Integer> weights;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        weights = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights.add(Integer.parseInt(st.nextToken()));
        }
        System.out.println(calculateEnergy(0));
    }

    private static int calculateEnergy(int energy) {
        int maxEnergy = energy;
        for (int i = 1; i < weights.size() - 1; i++) {
            int currentWeight = weights.remove(i);
            int currentEnergy = calculateEnergy(energy + weights.get(i - 1) * weights.get(i));
            maxEnergy = Math.max(maxEnergy, currentEnergy);
            weights.add(i, currentWeight);
        }
        return maxEnergy;
    }
}
