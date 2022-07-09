import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        List<Integer> results = new ArrayList<>();
        while (true) {
            String input = scanner.nextLine();
            String[] LPV = input.split(" ");
            Integer L = Integer.parseInt(LPV[0]);
            Integer P = Integer.parseInt(LPV[1]);
            Integer V = Integer.parseInt(LPV[2]);
            if (L == 0 && P == 0 && V == 0) {
                break;
            }
            Integer result = (V/P)*L;
            if (V % P > L) {
                result += L;
            } else {
                result += V % P;
            }
            results.add(result);
        }
        for (Integer result : results) {
            count += 1;
            System.out.printf("Case %d: %d%n", count, result);
        }
    }
}
