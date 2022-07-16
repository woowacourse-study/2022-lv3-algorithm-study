package study.coding.test.backjoon.week_2;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * 요세푸스 문제 0
 *
 * 원형 순서 + k번째
 */
class Sol_1_11866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        LinkedList<Integer> q = new LinkedList<>();

        String result = solve(input, q);

        out.println(result);

        br.close();
    }

    private static String solve(String input, LinkedList<Integer> q) {
        StringTokenizer st = new StringTokenizer(input);

        int input_number_size = Integer.parseInt(st.nextToken());
        int next_size = Integer.parseInt(st.nextToken()) - 1;

        for (int number = 1; number <= input_number_size; number++) {
            q.add(number);
        }

        /**
         * (current index + next_size) % current_size
         */
        int current_index = 0;
        List<String> result_sequence = new ArrayList<>();

        while (q.size() > 0) {
            int current_size = q.size();
            int target_index = (current_index + next_size) % current_size;
            Integer target = q.get(target_index);
            current_index = target_index;
            result_sequence.add(String.valueOf(target));
            q.remove(target);
        }

        String result =
                "<"
                        + result_sequence.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "))
                        + ">";
        return result;
    }
}
