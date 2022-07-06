import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = 0;
        while (true) {
            line++;
            int l = scanner.nextInt();
            int p = scanner.nextInt();
            int v = scanner.nextInt();
            if ((l + p + v) == 0) {
                break;
            }

            int dayCount = (v / p * l) + Integer.min(l, v % p);
            System.out.printf("Case %d: %d%n", line, dayCount);
            scanner.nextLine();
        }
    }
}
