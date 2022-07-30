package boj.boj16198;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        calculate(arr, N, 0);
        System.out.println(max);
    }

    private static void calculate(int[] arr, int n, int total) {
        int[] newArr = createNewArray(arr, n);
        if (isEnd(newArr)) {
            max = Math.max(max, total);
            return;
        }
        for (int i = 1; i < n - 1; i++) {
            int weight = newArr[i];
            newArr[i] = 0;
            calculate(newArr, n - 1, total + newArr[i - 1] * newArr[i + 1]);
            newArr[i] = weight;
        }
    }

    private static boolean isEnd(int[] newArr) {
        return newArr.length == 2;
    }

    private static int[] createNewArray(int[] arr, int n) {
        int[] newArr = new int[n];
        int index = 0;
        for (int weight : arr) {
            if (weight != 0) {
                newArr[index++] = weight;
            }
        }
        return newArr;
    }
}
