import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Kun_16498 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int countA = Integer.parseInt(st.nextToken());
        int[] aCards = new int[countA];
        int countB = Integer.parseInt(st.nextToken());
        int[] bCards = new int[countB];
        int countC = Integer.parseInt(st.nextToken());
        int[] cCards = new int[countC];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < countA; i++) {
            aCards[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < countB; i++) {
            bCards[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < countC; i++) {
            cCards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(aCards);
        Arrays.sort(bCards);
        Arrays.sort(cCards);

        int pointA = 0;
        int pointB = 0;
        int pointC = 0;

        int result = Integer.MAX_VALUE;
        while (true) {
            int max = Math.max(Math.max(aCards[pointA], bCards[pointB]), cCards[pointC]);
            int min = Math.min(Math.min(aCards[pointA], bCards[pointB]), cCards[pointC]);
            if (max - min < result) {
                result = max - min;
            }
            if (min == aCards[pointA] && pointA < countA - 1) {
                pointA++;
            } else if (min == bCards[pointB] && pointB < countB - 1) {
                pointB++;
            } else if (min == cCards[pointC] && pointC < countC - 1) {
                pointC++;
            } else {
                break;
            }
        }

        System.out.println(result);
    }
}
