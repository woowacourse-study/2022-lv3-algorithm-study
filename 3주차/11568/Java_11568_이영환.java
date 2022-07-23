import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main { // 민균이의 계략

    static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int n = Integer.parseInt(bf.readLine());
        final StringTokenizer st = new StringTokenizer(bf.readLine());
        final List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        final List<Integer> lis = new ArrayList<>();
        for (Integer num : arr) {
            if (lis.size() == 0) {
                lis.add(num);
            } else {
                if (num > lis.get(lis.size() - 1)) {
                    lis.add(num);
                } else {
                    final int lowerBound = findLowerBound(lis, num);
                    lis.set(lowerBound, num);
                }
            }
        }

        System.out.println(lis.size());
    }

    private static int findLowerBound(final List<Integer> sortedArr, final int value) {
        int begin = 0;
        int end = sortedArr.size();

        // 이분탐색
        while(begin < end) {
            int mid = (begin + end) / 2;

            if(sortedArr.get(mid) >= value) {
                end = mid;
            }
            else {
                begin = mid + 1;
            }
        }
        return end;
    }
}
