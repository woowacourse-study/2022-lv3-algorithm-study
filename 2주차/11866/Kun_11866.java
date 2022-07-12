import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Kun_11866 {
    public static void main(String[] args) throws IOException {
        Deque<Integer> que = new LinkedList();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            que.offer(i);
        }
        sb.append("<");

        while(n-- >0) {
            if(que.size()!=1) {
                for (int i = 0; i < k-1; i++) {
                    que.offer(que.poll());
                }
                sb.append(que.poll()+", ");
            }
            else
                sb.append(que.poll()+">");
        }


        System.out.println(sb);

    }
}
