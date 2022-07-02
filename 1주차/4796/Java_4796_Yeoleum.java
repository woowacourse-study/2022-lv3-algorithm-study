import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Java_4796_Yeoleum {

    final static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int index = 0;
        while(true) {
            String st = r.readLine();

            if(st.equals("0 0 0")){
                break;
            }

            String[] elements = st.split(" ");
            final int l = Integer.parseInt(elements[0]);
            final int p = Integer.parseInt(elements[1]);
            final int v = Integer.parseInt(elements[2]);

            int days = (v / p) * l + min(v % p, l);
            index++;
            System.out.println("Case "+ index +": "+ days);
        }
    }
}
