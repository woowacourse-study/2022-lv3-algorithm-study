import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        final StringTokenizer st = new StringTokenizer(r.readLine());
        final int n = Integer.parseInt(st.nextToken());
        Integer[] values = {2, 1, 2, 3, 4, 5, 4, 3};

        System.out.println(values[n % 8]);
    }
}
