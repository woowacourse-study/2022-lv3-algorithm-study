import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int size = S.length();
        int center = size / 2;

        for (int i = center; i < size; i++) {
            String right = S.substring(i);
            int leftStartIndex = Math.max(i - right.length(), 0);
            String left = S.substring(leftStartIndex, i);
            if (left.equals(new StringBuilder(right).reverse().toString())) {
                System.out.println(size + leftStartIndex);
                return;
            }

            right = S.substring(i + 1);
            leftStartIndex = i - right.length();
            left = S.substring(leftStartIndex, i);
            if (left.equals(new StringBuilder(right).reverse().toString())) {
                System.out.println(size + leftStartIndex);
                return;
            }
        }
    }
}
