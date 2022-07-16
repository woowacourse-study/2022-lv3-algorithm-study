import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class a11866 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> input = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Integer N = input.get(0);
        Integer K = input.get(1);
        int beforeIndex = 0;
        ArrayList<Integer> results = new ArrayList<>();
        List<Integer> list = IntStream.rangeClosed(1, N).boxed().collect(Collectors.toList());
        while (!list.isEmpty()) {
            int nowIndex = (beforeIndex + (K - 1)) % list.size();
            results.add(list.remove(nowIndex));
            beforeIndex = nowIndex;
        }
        System.out.println(results.toString()
                .replace("[", "<")
                .replace("]", ">")
        );
    }
}
