import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main5904 {

    final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int number = Integer.parseInt(reader.readLine());
        int mooLength = 3;
        int total = 3;

        while (number > total) {
            int buf = total * 2;
            mooLength ++;
            total = buf + mooLength;
        }

        while (true) {
            String result = process(number, mooLength, total);

            if (result.equals("m") || result.equals("o")) {
                System.out.print(result);
                break;
            }

            total = (total - mooLength) / 2;
            int buf = number - (total + mooLength);
            if (buf < 0) {
                number = number;
            } else {
                number = number - (total + mooLength);
            }
            mooLength = mooLength - 1;
        }
    }

    private static String process(int number, int mooLength, int total) {
        int buf = (total - mooLength) / 2;
        if (buf == number) {
            return "o";
        } else if (buf < number && number <= (buf + mooLength)) {
            if (number == (buf + 1)) {
                return "m";
            } else {
                return "o";
            }
        } else {
            return "";
        }
    }
}
