import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int n = Integer.parseInt(bf.readLine());
        final char character = findThisPositionCharacter("moo", n, 1);

        System.out.println(character);
    }

    private static char findThisPositionCharacter(final String moo, final int n, final int cycle) {
        if (moo.length() < n) {
            final String newMoo = moo + "m"
                    + "o".repeat(cycle + 2)
                    + moo;
            return findThisPositionCharacter(newMoo, n, cycle + 1);
        }
        return moo.charAt(n - 1);
    }
}
