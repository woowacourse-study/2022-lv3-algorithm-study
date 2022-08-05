import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    private static int n, k;
    private static int[] numbers;
    private static int[] sortedNumbers;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());

        numbers = Arrays.stream(bufferedReader.readLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        k = Integer.parseInt(bufferedReader.readLine());

        sortedNumbers = new int[n];
        mergeSort(0, n - 1);

        String result = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }

    private static void mergeSort(int left, int right) {
        if (left == right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(left, mid);
        mergeSort(mid + 1, right);

        merge(left, mid, right);
    }

    private static void merge(int left, int mid, int right) {
        /*
         * right - left -> 현재 병합해야 하는 왼쪽 서브 리스트와 오른쪽 서브 리스트의 총 크기
         */
        if (right - left > n / k) {
            return;
        }

        int l = left;
        int r = mid + 1;
        int index = left;

        while (l <= mid && r <= right) {
            if (numbers[l] <= numbers[r]) {
                sortedNumbers[index] = numbers[l];
                index++;
                l++;
            } else {
                sortedNumbers[index] = numbers[r];
                index++;
                r++;
            }
        }

        while (r <= right) {
            sortedNumbers[index] = numbers[r];
            index++;
            r++;
        }

        while (l <= mid) {
            sortedNumbers[index] = numbers[l];
            index++;
            l++;
        }

        for (int i = left; i <= right; i++) {
            numbers[i] = sortedNumbers[i];
        }
    }
}
