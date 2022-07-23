import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int pLength = 0;
        for (int i = 0; i < input.length(); i++) {
            StringBuilder s = new StringBuilder(input.substring(i));
            if (s.toString().equals(s.reverse().toString())) {
                pLength = Math.max(s.length(), pLength);
            }
        }
        System.out.println(input.length() + input.length() - pLength);
    }
}
