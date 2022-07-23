import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int left = 0;
        int right = arr.length - 1;
        StringBuilder temp = new StringBuilder();
        while (left <= right) {
            temp.reverse();
            if (isPalindrome(new String(arr).concat(temp.toString())) ||
                    isPalindrome(new String(arr).concat(temp.reverse().toString()))) {
                break;
            }
            temp.append(arr[left++]);
        }
        System.out.println(arr.length + temp.length());
    }

    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        char[] arr = str.toCharArray();
        while (left < right && arr[left] == arr[right]) {
            left++;
            right--;
        }
        return left >= right;
    }
}
