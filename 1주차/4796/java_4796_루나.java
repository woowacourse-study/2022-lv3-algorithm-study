import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;

        while(true){
            String[] input = br.readLine().split(" ");

            int L = Integer.parseInt(input[0]);
            int P = Integer.parseInt(input[1]);
            int V = Integer.parseInt(input[2]);

            if(L == 0 && P == 0 && V == 0){
                break;
            }

            cnt++;
            int q = V / P;
            int r = V % P;
            int result = q * L + Math.min(r, L);

            System.out.printf("Case %d: %d\n", cnt, result);
        }
    }
}