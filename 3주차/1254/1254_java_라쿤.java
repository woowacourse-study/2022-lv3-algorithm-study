import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String input() {
        try {
            return reader.readLine().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String data = input();

        int answer = -1;

        if (data.length() == 1) {
            System.out.println(1);
            return;
        }

        for (int i = data.length() / 2; i <= data.length(); i++) {
            String maked = data.substring(0, i) + reverse(data.substring(0, i));
            String makedCenterMe = data.substring(0, i) + reverse(data.substring(0, i-1));

            if (makedCenterMe.length() >= data.length() && makedCenterMe.startsWith(data)) {
                answer = makedCenterMe.length();
                break;
            }

            if (maked.length() >= data.length() && maked.startsWith(data)) {
                answer = maked.length();
                break;
            }
        }

        System.out.println(answer);
    }

    private static String reverse(String substring) {
        StringBuilder sb = new StringBuilder(substring);

        return sb.reverse().toString();
    }
}
