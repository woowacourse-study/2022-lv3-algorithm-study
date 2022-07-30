import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		int length = S.length();
		int answer = 0;

		for (int i = 0; i < length; i++) {
			String substr = S.substring(i);
			StringBuilder reverse = new StringBuilder(substr).reverse();
			if(substr.equals(reverse.toString())){
				break;
			}
			answer ++ ;
		}

		System.out.println(length + answer);
	}
}
