import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int finger = number % 8;
        if (finger > 5) {
            finger = 10 - finger;
        }
        if (finger == 0) {
            finger = 2;
        }
        System.out.println(finger);
    }
}
