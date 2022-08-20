package boj.p24393;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Queue<Integer> firstDeck = new LinkedList<>();
    static Queue<Integer> leftDeck = new LinkedList<>();
    static Queue<Integer> rightDeck = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        firstDeck.add(-1);
        for (int i = 0; i < 26; i++) {
            firstDeck.add(1);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 13; j++) {
                leftDeck.add(firstDeck.poll());
            }
            for (int j = 0; j < 14; j++) {
                rightDeck.add(firstDeck.poll());
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = 0;
            boolean flag = true;
            while(cnt < 27) {
                int newDeckCnt = Integer.parseInt(st.nextToken());
                cnt += newDeckCnt;
                for (int j = 0; j < newDeckCnt; j++) {
                    if (flag) {
                        firstDeck.add(rightDeck.poll());
                    } else {
                        firstDeck.add(leftDeck.poll());
                    }
                }
                flag = !flag;
            }
        }

        int answer = 1;
        for (Integer card : firstDeck) {
            if (card == -1) {
                break;
            }
            answer++;
        }

        bw.write(answer + "");
        bw.flush();

        br.close();
        bw.close();
    }
}
