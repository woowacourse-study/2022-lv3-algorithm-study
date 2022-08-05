import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static List<Set<String>> manitos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int tryCount = 1;
        while (N != 0) {
            manitos = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();

                int index = findIndex(name1, name2);
                if (index != -1) {
                    manitos.get(index).add(name1);
                    manitos.get(index).add(name2);
                } else {
                    Set<String> list = new HashSet<>();
                    list.add(name1);
                    list.add(name2);
                    manitos.add(list);
                }
            }

            System.out.println(tryCount++ + " " + manitos.size());
            N = Integer.parseInt(br.readLine());
        }
        br.close();
    }

    private static int findIndex(String name1, String name2) {
        int size = manitos.size();
        for (int i = 0; i < size; i++) {
            if (manitos.get(i).contains(name1) || manitos.get(i).contains(name2)) {
                return i;
            }
        }
        return -1;
    }
}
