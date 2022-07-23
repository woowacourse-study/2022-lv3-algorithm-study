import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        int count = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.substring(i))) {
                break;
            }
            count++;
        }

        System.out.println(count);
    }

    private static boolean isPalindrome(String word) {
        int half = word.length() / 2;
        for (int i = 0; i < half; i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
