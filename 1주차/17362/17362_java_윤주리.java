package PS;

import java.util.Scanner;

public class Math2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n <= 5) {
            System.out.println(n);
        } else {
            int number = n - 5;
            if (((number - 1) / 4) % 2 == 0) {//오른쪽에서 왼쪽으로 증가하는 경우
                System.out.println((number % 4 == 0) ? 1 : 5 - number % 4);
            } else {// 왼쪽에서 오른쪽으로 증가하는 경우
                System.out.println((number % 4 == 0) ? 5 : number % 4 + 1);
            }
        }
    }

}
