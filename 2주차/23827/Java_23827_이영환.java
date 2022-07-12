import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        final int permutationLength = Integer.parseInt(sc.nextLine());
        final String rawPermutation = sc.nextLine();

        System.out.println(getAllPairCombinationMulSum(permutationLength, rawPermutation));
    }

    private static long getAllPairCombinationMulSum(final int permutationLength, final String rawPermutation) {
        final String[] rawNumbers = rawPermutation.split("\\s+");
        BigInteger allPairCombinationMulSum = new BigInteger("0");
        BigInteger numberSum = new BigInteger("0");

        for (int i = 0; i < permutationLength; i++) {
            final long nowNumber = Long.parseLong(rawNumbers[i]);
            allPairCombinationMulSum = allPairCombinationMulSum.add(numberSum.multiply(new BigInteger("" + nowNumber)));
            numberSum = numberSum.add(new BigInteger("" + nowNumber));
        }

        return allPairCombinationMulSum.remainder(new BigInteger("1000000007")).longValue();
    }
}
