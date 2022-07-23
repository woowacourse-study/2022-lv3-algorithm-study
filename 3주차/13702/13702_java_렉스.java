import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 이분 탐색 개념을 까먹어서...해당 문제는 구글의 도움을 받았습니다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] kettle = new long[N];
        for (int i = 0; i < N; i++) {
            kettle[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(kettle);

        long low = kettle[0] / K;
        long max = kettle[N - 1];
        long middle = (low + max) / 2; // 막걸리 용량

        while (low <= max) {
            int numOfPeople = 0; // 분배받을 수 있는 사람의 수
            for (long k : kettle) { // 현재 용량으로 분배받을 수 있는 사람 수 계산
                numOfPeople += (k / middle);
            }

            if (numOfPeople < K) { // 분배 받을 수 있는 인원이 적은 경우
                max = middle - 1;
            } else {
                low = middle + 1;
            }
            middle = (low + max) / 2;
        }
        System.out.println(max);
    }
}
