import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class josh_java_17123 {

    // 1. 2차원 배열에 각 쿼리가 들어올때마다 업데이트를 하면 N*N*M으로 시간초과
    //     -> 쿼리를 합쳐 한번에 2차원 배열을 update 할 수 없을까?
    //        - 새로운 쿼리가 들어오면 기존 쿼리와 모두 비교해 겹치는지 확인해야함
    //        - 겹치는 쿼리를 분리해 여러 쿼리로 만드는 로직이 너무 복잡할거 같음(그리고 쿼리가 계속 늘어남)

    // 2. 문제에서 각 행, 열의 합을 요구함
    //     -> 행의 합, 열의 합을 데이터로 저장하고, 쿼리가 들어오면 해당 행/열의 총 합이 증가된 만큼 업데이트
    //         -> M*(N+N)으로 해결 가능

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNumber = Integer.parseInt(bf.readLine());
        for (int i = 0; i<testCaseNumber; ++i) {
            solve(bf);
        }
        bf.close();
    }

    private static void solve(BufferedReader bf) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> sumOfRow = new ArrayList<>(Collections.nCopies(N, 0));
        List<Integer> sumOfColumn = new ArrayList<>(Collections.nCopies(N, 0));

        for (int i = 0; i<N; ++i) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j<N; ++j) {
                int value = Integer.parseInt(st.nextToken());
                sumOfRow.set(i, sumOfRow.get(i) + value);
                sumOfColumn.set(j, sumOfColumn.get(j) + value);
            }
        }

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(bf.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;
            int value = Integer.parseInt(st.nextToken());

            int rowUpdateUnit = c2 - c1 + 1;
            int columnUpdateUnit = r2 - r1 + 1;

            for (int index = r1; index <= r2; ++index) {
                sumOfRow.set(index, sumOfRow.get(index) + value * rowUpdateUnit);
            }
            for (int index = c1; index <= c2; ++index) {
                sumOfColumn.set(index, sumOfColumn.get(index) + value * columnUpdateUnit);
            }
        }
        for (int element : sumOfRow) {
            System.out.print(element + " ");
        }
        System.out.println();
        for (int element : sumOfColumn) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
