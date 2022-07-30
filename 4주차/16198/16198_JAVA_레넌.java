package boj.p16198;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int energy = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bf.readLine());
        List<Integer> energies = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            energies.add(Integer.parseInt(st.nextToken()));
        }

        dfs(n, energies, 0);

        bw.write(energy + "");
        bw.flush();

        bf.close();
        bw.close();
    }

    private static void dfs(int n, List<Integer> energies, int sum) {
        if (n == 2) {
            energy = Math.max(sum, energy);
            return;
        }
        for (int i = 1; i < n - 1; i++) {
            int s = energies.get(i - 1) * energies.get(i + 1);
            int tmp = energies.get(i);
            energies.remove(i);
            dfs(n - 1, energies, sum + s);
            energies.add(i, tmp);
        }
    }
}
