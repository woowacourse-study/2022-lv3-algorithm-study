package algorithm_study.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class java_14659_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[] heights = new int[number];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < number; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(calculateMaxCombo(number, heights));
    }

    private static int calculateMaxCombo(int number, int[] heights) {
        int maxCombo = 0;
        int combo = 0;
        int pivot = heights[0];
        if (number == 0) {
            return 0;
        }

        for (int i = 1; i < number; i++) {
            if (heights[i] < pivot) {
                combo++;
            }
            if (heights[i] > pivot) {
                if (combo > maxCombo) {
                    maxCombo = combo;
                }
                combo = 0;
                pivot = heights[i];
            }
        }
        return Math.max(combo, maxCombo);
    }
}
