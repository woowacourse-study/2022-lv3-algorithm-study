package algorithm_study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class java_12789_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] waitingLine = new int[N];
        int pivot = -1;
        int current = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int top = Integer.parseInt(st.nextToken());
            if (top == current) {
                current++;
                while (pivot >= 0 && waitingLine[pivot] == current) {
                    pivot--;
                    current++;
                }
            } else {
                waitingLine[++pivot] = top;
            }
        }

        String answer = pivot < 0 ? "Nice" : "Sad";
        System.out.println(answer);
    }
}
