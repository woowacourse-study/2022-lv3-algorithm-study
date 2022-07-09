import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // input
        int n = Integer.parseInt(bf.readLine());
        String[][] arr = new String[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }
        bf.close();

        // sort
        Arrays.sort(arr, Comparator.comparingInt(arr2 -> Integer.parseInt(arr2[0])));

        // print
        for (String[] a : arr) {
            sb.append(a[0])
                    .append(" ")
                    .append(a[1])
                    .append("\n");
        }
        System.out.println(sb);
    }
}
