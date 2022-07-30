import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            int count = findManito(br, N);
            sb.append(testCase)
                    .append(" ")
                    .append(count)
                    .append("\n");
            testCase++;
        }
        System.out.println(sb);
    }

    private static int findManito(BufferedReader br, int N) throws IOException {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String start = st.nextToken(); // 선행을 베푸는 자
            String end = st.nextToken(); // 선행을 받는 자
            map.put(start, end);
        }

        int numOfChain = 0;
        Set<String> personInTheChain = new HashSet<>(); // 이미 체인을 이룬 모든 사람들이 포함되는 set
        for (String name : map.keySet()) {
            if (personInTheChain.contains(name)) { // 이미 체인을 이루고 있다면 Pass
                continue;
            }

            Set<String> chain = new HashSet<>();
            while (map.containsKey(name)) { // 다음 사람들을 확인하며 체인 확인
                if (chain.contains(name)) {
                    // 현재 체인에 다음 사람이 포함되면 체인이 형성된 것임으로 체인의 수를 높이고 personInTheChain에 현재의 사람들 추가
                    numOfChain++;
                    personInTheChain.addAll(chain);
                    break;
                } else {
                    chain.add(name);
                }
                name = map.get(name);
            }
        }
        return numOfChain;
    }
}
