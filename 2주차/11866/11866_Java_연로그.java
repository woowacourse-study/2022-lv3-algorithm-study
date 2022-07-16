import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        StringBuilder sb = draw(N, K, new StringBuilder());
        System.out.println(sb);
        bf.close();
    }

    static StringBuilder draw(int N, int K, StringBuilder sb) {
        List<Integer> numbers = initList(N);
        sb.append("<");

        int index = 0;
        for (int i = 0; i < N; i++) {
            if (i != 0) {
                sb.append(", ");
            }

            index += K - 1;
            int size = numbers.size();
            if (index > size - 1) {
                index = index % size;
            }
            sb.append(numbers.remove(index));
        }
        sb.append(">");
        return sb;
    }

    private static List<Integer> initList(int n) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        return list;
    }
}
