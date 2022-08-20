package boj.p16498;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int countOfA = parseInt(st.nextToken());
        int[] cardOfA = new int[countOfA];
        int countOfB = parseInt(st.nextToken());
        int[] cardOfB = new int[countOfB];
        int countOfC = parseInt(st.nextToken());
        int[] cardOfC = new int[countOfC];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < countOfA; i++) {
            cardOfA[i] = parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < countOfB; i++) {
            cardOfB[i] = parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < countOfC; i++) {
            cardOfC[i] = parseInt(st.nextToken());
        }

        Arrays.sort(cardOfA);
        Arrays.sort(cardOfB);
        Arrays.sort(cardOfC);

        int pointA = 0;
        int pointB = 0;
        int pointC = 0;

        int result = Integer.MAX_VALUE;
        while (true) {
            int max = Math.max(Math.max(cardOfA[pointA], cardOfB[pointB]), cardOfC[pointC]);
            int min = Math.min(Math.min(cardOfA[pointA], cardOfB[pointB]), cardOfC[pointC]);
            if (max - min < result) {
                result = max - min;
            }
            if (min == cardOfA[pointA] && pointA < cardOfA.length - 1) {
                pointA++;
            } else if (min == cardOfB[pointB] && pointB < cardOfB.length - 1) {
                pointB++;
            } else if (min == cardOfC[pointC] && pointC < cardOfC.length - 1) {
                pointC++;
            } else {
                break;
            }
        }

        bw.write(result + "");
        bw.flush();

        bw.close();
        br.close();
    }
}
