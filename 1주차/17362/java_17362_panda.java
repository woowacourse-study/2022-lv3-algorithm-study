package algorithm_study.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class java_17362_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        System.out.println(findFinger(number));
    }
    private static int findFinger(int number){
        switch ((number - 1) % 8) {
            case 0:
                return 1;
            case 1:
            case 7:
                return 2;
            case 2:
            case 6:
                return 3;
            case 3:
            case 5:
                return 4;
            case 4:
                return 5;

        }
        return -1;
    }
}
