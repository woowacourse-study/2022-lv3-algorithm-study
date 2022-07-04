import java.util.Scanner;

public class BOJ_17362 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] answers = {2, 1, 2, 3, 4, 5, 4, 3};

        System.out.println(answers[n % 8]);
    }
}
