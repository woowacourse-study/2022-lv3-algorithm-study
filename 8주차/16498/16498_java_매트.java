import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BOJ16498 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        List<Integer> aCards = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            aCards.add(scanner.nextInt());
        }

        List<Integer> bCards = new ArrayList<>();
        for (int i = 0; i < b; i++) {
            bCards.add(scanner.nextInt());
        }

        List<Integer> cCards = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            cCards.add(scanner.nextInt());
        }

        aCards.sort(Comparator.naturalOrder());
        bCards.sort(Comparator.naturalOrder());
        cCards.sort(Comparator.naturalOrder());

        int aIndex = 0;
        int bIndex = 0;
        int cIndex = 0;

        int result = Integer.MAX_VALUE;
        while (true) {
            int max = max(aCards.get(aIndex), bCards.get(bIndex), cCards.get(cIndex));
            int min = min(aCards.get(aIndex), bCards.get(bIndex), cCards.get(cIndex));

            result = Math.min(result, max - min);

            if (aIndex < aCards.size() - 1 && min == aCards.get(aIndex)) {
                aIndex++;
            } else if (bIndex < bCards.size() - 1 && min == bCards.get(bIndex)) {
                bIndex++;
            } else if (cIndex < cCards.size() - 1 && min == cCards.get(cIndex)) {
                cIndex++;
            } else {
                System.out.println(result);
                return;
            }
        }
    }

    private static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    private static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
