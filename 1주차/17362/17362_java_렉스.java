import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int r = n % 8;

        if (r == 0) {
            r = 2;
        }
        else if (r > 5) {
            r = 10 - r;
        }

        System.out.println(r);
        br.close();
    }
}
