import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static class Building {
        int idx;
        long height;

        public Building(int idx, long height) {
            this.idx = idx;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] buildingHeights = new long[N];
        int[] buildingCnts = new int[N];

        long answer = 0;
        Stack<Building> buildingStack = new Stack<>();

        for (int i = 0; i < N; i++) {
            buildingHeights[i] = Long.parseLong(br.readLine());
        }

        for (int i = N - 1; i >= 0; i--) {
            long buildingHeight = buildingHeights[i];
            if (buildingStack.isEmpty() || buildingStack.peek().height >= buildingHeight) {
                buildingStack.push(new Building(i, buildingHeight));
            } else {
                int cnt = 0;
                while (!buildingStack.isEmpty() && buildingStack.peek().height < buildingHeight) {
                    cnt += buildingCnts[buildingStack.pop().idx] + 1;
                }
                buildingCnts[i] = cnt;
                answer += cnt;
                buildingStack.push(new Building(i, buildingHeight));
            }
        }
        System.out.println(answer);
    }
}