import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ11866 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Integer> people = initPeople(n);
        final List<Integer> answer = yosephusPro(people, k);
        output(answer);
    }

    private static List<Integer> initPeople(int n) {
        List<Integer> people = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }
        return people;
    }

    private static List<Integer> yosephusPro(List<Integer> people, int k) {
        List<Integer> answer = new ArrayList<>();
        int target = 0;
        while (!people.isEmpty()) {
            target = moveTargetIndex(target, k, people.size());
            Integer goneMan = people.remove(target);
            answer.add(goneMan);
        }
        return answer;
    }

    private static int moveTargetIndex(int target, int k, int peopleSize) {
        if (isOutOfNumberOfPeople(target, peopleSize)) {
            target = 0;
        }
        for (int i = 0; i < k - 1; i++) {
            if (target == peopleSize - 1) {
                target = 0;
                continue;
            }
            target++;
        }
        return target;
    }

    private static void output(List<Integer> answer) {
        System.out.print("<");
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i));

            if (i == answer.size() - 1) {
                continue;
            }
            System.out.print(", ");
        }
        System.out.print(">");
    }

    private static boolean isOutOfNumberOfPeople(int target, int peopleSize) {
        return target > peopleSize - 1;
    }
}
