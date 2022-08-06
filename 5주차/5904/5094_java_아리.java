import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // N개 이상의 글자를 가지는 k 찾기
        int k = 0;
        int length = 3;
        while (N > length) {
            k++;
            length = 2 * length + k + 3;
        }

        moo(k, length, N);
    }

    private static void moo(int k, int length, int num) {
        if (k < 0) {
            return;
        }

        // 가운데 시작점
        int mid = (length - k - 3) / 2 + 1;

        // 가운데 시작점과 같다면 무조건 m
        if (num == mid) {
            System.out.println("m");
            return;
        }

        // 가운데에 속해있지만 시작점은 아니라면 무조건 o
        else if (num > mid && num < mid + k + 3) {
            System.out.println("o");
            return;
        }

        // 왼쪽 S(k-1)
        else if (num < mid) {
            moo(k - 1, mid - 1, num);
        }

        // 오른쪽 S(k-1)
        else {
            moo(k - 1, mid - 1, num - mid - k - 2);
        }

    }

}
