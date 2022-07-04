import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(br.readLine());

        int x = i % 8;
        if (i <= 5) {
            System.out.println(i);
        } else if (x == 6) {
            System.out.println(4);
        } else if (x == 7) {
            System.out.println(3);
        } else if (x == 0) {
            System.out.println(2);
        } else {
            System.out.println(x);
        }
    }
}
