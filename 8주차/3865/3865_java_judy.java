package PS;

import java.io.*;
import java.util.*;

public class 학회원 {


    static HashMap<String, ArrayList<String>> map = new HashMap<>();
    static HashSet<String> visit = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n;
        String target="";
        while ((n = Integer.parseInt((br.readLine()))) != 0) {
            map.clear();
            visit.clear();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), ":|,|.");

                String key = st.nextToken();
                if (i == 0) {
                    target = key;
                }
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                while (st.hasMoreTokens()) {
                    map.get(key).add(st.nextToken());
                }
            }
            visit.add(target);
            System.out.println(dfs(target, 0));
        }
    }

    private static int dfs(String key, int count) {
        if (map.containsKey(key)) {
            for (String child : map.get(key)) {
                if (!visit.contains(child)) {
                    visit.add(child);
                    count += dfs(child, map.get(child) == null ? 1 : 0);
                }
            }
        }
        return count;
    }
}
