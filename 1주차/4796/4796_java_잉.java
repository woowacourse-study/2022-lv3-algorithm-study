import java.util.Scanner;

public class BOJ4796 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (true) {
            i++;
            int l = scanner.nextInt();
            int p = scanner.nextInt();
            int v = scanner.nextInt();
            if (l == 0 && p == 0 && v == 0) {
                break;
            }
            System.out.println("Case " + i + ": " + letGoCamp(l, p, v));
        }
    }

    private static int letGoCamp(int limitDay, int totalDay, int vacationDay) {
        final int first = (vacationDay / totalDay) * limitDay;
        final int second = vacationDay % totalDay;
        if (limitDay <= second) {
            return first + limitDay;
        }
        return first + second;
    }
}
