package PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Moo_게임 {

    static char[] moo = {'m', 'o', 'o'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        mooGame(n, 1, 3);
    }

    private static void mooGame(int n, int index, int length) {
        if (n <= 3) {
            System.out.println(moo[n - 1]);
            return;
        }
        int nextLength = length * 2 + index + 3;//s(index+1)의 길이
        if (nextLength < n) {//s(index+1)의 길이로 알 수 없을 때
            mooGame(n, index + 1, nextLength);
            return;
        }
        if (n > length && n <= length + index + 3) {//index~index+3구간 일 때
            if (n - length == 1) {
                System.out.println("m");
            } else {
                System.out.println("o");
            }
            return;
        }
        mooGame(n - length - index - 3, 1, 3);
    }
}
