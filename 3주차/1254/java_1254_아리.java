import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            String subInput = input.substring(i);
            StringBuilder compare = new StringBuilder(subInput).reverse();

            if (subInput.equals(compare.toString())) {
                break;
            }

            count++;
        }

        System.out.println(input.length() + count);
    }
}
