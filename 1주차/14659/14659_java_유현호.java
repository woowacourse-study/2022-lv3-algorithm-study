import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] 봉우리들 = new int[N];
        int 최대_높이;
        int 현재_처치수 = 0;
        int 최대_처치수 = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 봉우리들.length; i++) {
            봉우리들[i] = Integer.parseInt(st.nextToken());
        }
        최대_높이 = 봉우리들[0];

        for (int i = 0; i < N; i++) {
            int 현재_높이 = 봉우리들[i];
            if (최대_높이 <= 현재_높이) {
                최대_높이 = 현재_높이;
                최대_처치수 = Math.max(최대_처치수, 현재_처치수);
                현재_처치수 = 0;
            } else {
                현재_처치수++;
            }
        }
        System.out.println(Math.max(최대_처치수, 현재_처치수));
    }
}
