import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class josh_java_17362 {
    public static int solve(int count) {
        List<Integer> bucket = Arrays.asList(2, 1, 2, 3, 4, 5, 4, 3);
        int index = count % 8;
        return bucket.get(index);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int answer = solve(count);
        System.out.println(answer);
    }
}
