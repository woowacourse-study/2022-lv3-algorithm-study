import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main1254 {

    final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = reader.readLine();
        int size = input.length();

        int count = 0;
        while (true) {
            final StringBuffer sb = new StringBuffer(input);
            final String reverse = sb.reverse().toString();
            if (input.equals(reverse)) {
                break;
            }

            input = input.substring(1);
            count ++;
        }

        System.out.print(size + count);
    }
}
