import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        final String input = sc.nextLine();
        final String[] split = input.split("\\s+");
        final int n = Integer.parseInt(split[0]);
        final int k = Integer.parseInt(split[1]);

        final Permutation permutation = Permutation.of(n, k);

        System.out.println(permutation);
    }

    static class Permutation {

        private final List<Integer> value;

        private Permutation(final List<Integer> value) {
            this.value = value;
        }

        public static Permutation of(final int endNumber, final int jumpNumber) {
            return new Permutation(createPermutationValue(endNumber, jumpNumber));
        }

        private static List<Integer> createPermutationValue(final int endNumber, final int jumpNumber) {
            final List<Integer> numbers = createNumbers(endNumber);
            final List<Integer> permutation = new ArrayList<>();
            int lastRemovedIndex = 0;
            while (numbers.size() > 0) {
                final int removeIndex = findRemoveIndex(lastRemovedIndex, jumpNumber, numbers.size());
                lastRemovedIndex = removeIndex;
                final Integer removedNumber = numbers.remove(removeIndex);
                permutation.add(removedNumber);
            }

            return permutation;
        }

        private static List<Integer> createNumbers(final int n) {
            return IntStream.rangeClosed(1, n)
                    .boxed()
                    .collect(Collectors.toList());
        }

        private static int findRemoveIndex(final int lastRemovedIndex, final int k, final int numbersSize) {
            final int index = lastRemovedIndex + k - 1;

            if (index >= numbersSize) {
                return index % numbersSize;
            }

            return index;
        }

        @Override
        public String toString() {
            final String rawPermutation = value.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
            return "<" + rawPermutation + ">";
        }
    }
}
