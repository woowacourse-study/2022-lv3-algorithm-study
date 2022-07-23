package timecapsule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        while (st.hasMoreElements()) {
            list.add(Integer.valueOf(st.nextToken()));
        }
        dfs(list, 0);

        System.out.println(max);
    }

    private static void dfs(List<Integer> list, int sum) {
        if (list.size() == 2) {
            if (sum > max) {
                max = sum;
            }
            return;
        }

        for (int i = 1; i < list.size() - 1; i++) {
            int temp = list.get(i);
            int add = list.get(i - 1) * list.get(i + 1);
            list.remove(i);
            dfs(list, sum + add);
            list.add(i, temp);
        }
    }
}