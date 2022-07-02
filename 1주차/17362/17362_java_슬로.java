import java.util.Scanner;

public class Main17362 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(calculate(n % 8));
    }

    private static int calculate(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 0 || n == 2) {
            return 2;
        }
        if (n == 3 || n == 7) {
            return 3;
        }
        if (n == 4 || n == 6) {
            return 4;
        }
        return 5;
    }
}
