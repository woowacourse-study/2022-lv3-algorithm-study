import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int finger = n % 8;

        if (finger == 1) {
            System.out.println(1);
        }
        if (finger == 2 || finger == 0) {
            System.out.println(2);
        }
        if (finger == 3 || finger == 7) {
            System.out.println(3);
        }
        if (finger == 4 || finger == 6) {
            System.out.println(4);
        }
        if (finger == 5) {
            System.out.println(5);
        }
    }
}