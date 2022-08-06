import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Main11582 {

    final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int totalCount = Integer.parseInt(reader.readLine());

        List<Integer> chickens = Arrays
                .stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        final int personCount = Integer.parseInt(reader.readLine());
        final int count = totalCount / personCount;

        int buf = 0;
        List<Integer> result = new ArrayList<>();
        while (true) {
            List<Integer> slice = chickens.subList(buf, buf + count);
            Collections.sort(slice);
            result.addAll(slice);
            buf = buf + count;

            if (buf == totalCount) {
                break;
            }
        }

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }
}
