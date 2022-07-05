import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kun_17362 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int value = Integer.parseInt(st.nextToken());

        int[] ar = {2, 1, 2, 3, 4, 5, 4, 3};

        int aIndex = value % 8;
        System.out.println(ar[aIndex]);
    }
}
