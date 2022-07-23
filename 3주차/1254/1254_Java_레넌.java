package boj.p1254;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            String substring = s.substring(i);
            sb = new StringBuilder(substring);
            if (sb.reverse().toString().equals(substring)) {
                bw.write(s.length() + i + "");
                break;
            }
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
