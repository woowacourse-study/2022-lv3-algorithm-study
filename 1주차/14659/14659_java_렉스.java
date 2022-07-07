import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int top = 0;
        int kill = 0;
        int maxKill = 0;

        for (int h : arr) {
            if (h < top) {
                kill++;
                continue;
            }
            maxKill = Math.max(kill, maxKill);
            top = h;
            kill = 0;
        }
        maxKill = Math.max(kill, maxKill);

        System.out.println(maxKill);
    }
}
