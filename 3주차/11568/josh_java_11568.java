import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class josh_java_11568 {

    // 1. 배열의 가장 마지막 수 보다 크면 뒤에 붙인다.
    //     -> lis 확장
    // 2. 배열의 가장 마지막 수 보다 크지 않으면 이진탐색으로 배열에서 그 다음으로 큰 수를 찾아 바꾼다
    //     -> 새로 만들어지는 lis 후보를 저장하는 것. 어차피 더 작은 수이기 때문에 lis를 확장하는데엔 영향을 미치지 않는다.

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bf.readLine());
        List<Integer> bucket = Arrays.stream(bf.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> lis = new ArrayList<>();
        // 로직을 간단하게 하기 위해 모든 element보다 작은 쓰레기값을 넣어줌
        lis.add(-1);

        for (int element : bucket) {
            if (lis.get(lis.size() - 1) < element) {
                lis.add(element);
                continue;
            }
            setInProperPosition(lis, element);
        }

        System.out.println(lis.size() - 1);
        bf.close();
    }

    private static void setInProperPosition(List<Integer> lis, int element) {
        int first = 1;
        int last = lis.size() - 1;

        while (first <= last) {
            int mid = (first + last) / 2;
            int preTarget = lis.get(mid - 1);
            int target = lis.get(mid);

            if (preTarget < element && element < target) {
                lis.set(mid, element);
                return;
            }

            if (target >= element) {
                last = mid - 1;
            } else if (target < element) {
                first = mid + 1;
            }
        }
    }
}
