import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class java_17362_루키 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int temp = n % 8;
        System.out.println(calculate(temp));
    }

    private static int calculate(int temp) {
        if (temp == 2 || temp == 0) {
            return 2;
        }
        if (temp == 3 || temp == 7) {
            return 3;
        }
        if (temp == 4 || temp == 6) {
            return 4;
        }
        return temp;
    }
}


