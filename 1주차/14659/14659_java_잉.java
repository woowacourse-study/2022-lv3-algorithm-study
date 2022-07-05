import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ14659 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int topNum = scanner.nextInt();
        List<Integer> tops = new ArrayList<>();
        for (int i = 0; i < topNum; i++) {
            tops.add(scanner.nextInt());
        }
        System.out.println(crazyArcher(tops));
    }

    private static int crazyArcher(List<Integer> tops) {
        int bestNumberOfMurders = 0;
        for (int i = 0; i < tops.size(); i++) {
            bestNumberOfMurders = Math
                    .max(bestNumberOfMurders, countMurders(tops.get(i), tops.subList(i, tops.size())));
        }
        return bestNumberOfMurders;
    }

    private static int countMurders(int dragonHeight, List<Integer> tops) {
        int count = 0;
        for (int top : tops) {
            if (dragonHeight > top) {
                count++;
            }
            if (dragonHeight < top) {
                break;
            }
        }

        return count;
    }
}
