import java.util.Scanner;

public class BOJ17362 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(fuckingFinger(n));
    }

    private static int fuckingFinger(int n) {
        int c = n % 8;
        if (c == 1) {
            return 1;
        }
        if (c == 0 || c == 2) {
            return 2;
        }
        if (c == 3 || c == 7) {
            return 3;
        }
        if (c == 4 || c == 6) {
            return 4;
        }
        return 5;
    }
}
