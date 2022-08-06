import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_5904_Yeoleum {
    private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    private static String answer;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(r.readLine());
        moo(n);

        System.out.println(answer);
    }

    public static void moo(int n){
        int size=3;
        int index=0;

        if(n == 1){
            answer = "m";
        }else if(n <= 3){
            answer = "o";
        }else{
            while(size < n){
                size = size * 2 + index + 4;
                index++;
            }
            int front_back = (size - index - 3) / 2;

            if(size - front_back + 1 <= n){
                moo(n - size + front_back);
            }else if(n == front_back + 1){
                answer = "m";
            }else {
                answer = "o";
            }
        }
    }
}
