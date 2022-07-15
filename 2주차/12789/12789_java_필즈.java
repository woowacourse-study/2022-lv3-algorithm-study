package study.coding.test.backjoon.week_2;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Stack;

/**
 * Fail:
 */
class Sol_4_12789 {

    static int person_size;
    static int[] waitingLine;
    static Stack<Integer> shelter;

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        String output = solve(reader);
        out.println(output);
    }

    public static String solve(Reader reader) {
        BufferedReader br = new BufferedReader(reader);
        init(br);

        String[] inputs = read(br).split(" ");

        for (int i = 0; i < person_size; i++) {
            waitingLine[i] = Integer.parseInt(inputs[i]);
        }

        for (int i = 0; i < person_size - 1; i++) {
            int front_waiting_line_person = waitingLine[i];
            // 뒤에 큰 수가 있다면
            if (existLargeNumber(shelter, i)) {
                shelter.push(front_waiting_line_person);
            }
            // 대기열 중에선 가장 작은 수라면
            else {
                while (!shelter.isEmpty()) {
                    Integer front_shelter_person = shelter.peek();

                    // 셸터에 앞단에 있는 수가 더 작은 수라면
                    if (front_waiting_line_person > front_shelter_person) {
                        if (!isFirst_in_Shelter()) {
                            return "Sad";
                        }
                        shelter.pop();
                    } else {
                        break;
                    }
                }
            }
        }

        return isOrder() ? "Nice" : "Sad";
    }

    private static void init(BufferedReader br) {
        person_size = Integer.parseInt(read(br));
        waitingLine = new int[person_size];
        shelter = new Stack<>();
    }

    private static boolean isFirst_in_Shelter() {
        int size = shelter.size();
        if (size < 2) {
            return true;
        }
        Integer first = shelter.get(0);
        for (int i = 1; i < size - 1; i++) {
            Integer next = shelter.get(1);
            if (first > next) {
                return false;
            }
        }
        return true;
    }

    private static boolean isOrder() {
        if (shelter.size() < 2) {
            return true;
        }
        Integer first = shelter.pop();
        while (!shelter.isEmpty()) {
            Integer second = shelter.pop();
            if (first > second) {
                return false;
            }
            first = second;
        }
        return true;
    }

    private static String read(BufferedReader br) {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean existLargeNumber(Stack<Integer> shelter, int i) {
        for (int j = i + 1; j < person_size; j++) {
            if (waitingLine[i] > waitingLine[j]) {
                return true;
            }
        }
        return false;
    }
}
