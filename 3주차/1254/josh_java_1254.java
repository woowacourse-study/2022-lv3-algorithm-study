import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class josh_java_1254 {

    // 문자열의 한 곳을 기준으로 짜름
    //     -> 이때 해당 부분을 따로 뽑는 경우(ex. ab c ba)  따로 뽑지 않는 경우(ex. ab ba) 모두 고려해야 함
    // 기준의 뒷 부분 문자열 reverse가 기준의 앞 부분 문자열의 일부와 일치하면 해당 기준으로 팰린드롬을 만들 수 있음

    private static final int FAIL = -100;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();

        boolean success = false;
        for (int index = input.length() / 2; index < input.length(); ++index) {
            int resultOfDivideByTwo = divideByTwo(input, index);
            int resultOfDivideByThree = divideByThree(input, index);
            if (resultOfDivideByTwo != FAIL) {
                System.out.println(resultOfDivideByTwo);
                success = true;
                break;
            }
            if (resultOfDivideByThree != FAIL) {
                System.out.println(resultOfDivideByThree);
                success = true;
                break;
            }
        }
        if (!success) {
            System.out.println(input.length() * 2 - 1);
        }

        bf.close();
    }

    private static int divideByTwo(String input, int index) {
        if (input.length() % 2 == 1 && input.length() / 2 == index) {
            return FAIL;
        }
        String reverseSubString = new StringBuffer(input.substring(index)).reverse().toString();
        String subString = input.substring(index - reverseSubString.length(), index);

        if (subString.equals(reverseSubString)) {
            return index * 2;
        }
        return FAIL;
    }

    private static int divideByThree(String input, int index) {
        if (input.length() == index + 1) {
            return FAIL;
        }
        String reverseSubString = new StringBuffer(input.substring(index + 1)).reverse().toString();
        String subString = input.substring(index - reverseSubString.length(), index);

        if (subString.equals(reverseSubString)) {
            return index * 2 + 1;
        }
        return FAIL;
    }
}
