import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] ACard;
    static int[] BCard;
    static int[] CCard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ACardNum = Integer.parseInt(st.nextToken());
        int BCardNum = Integer.parseInt(st.nextToken());
        int CCardNum = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ACard = new int[ACardNum];
        init(st, ACard, ACardNum);
        st = new StringTokenizer(br.readLine());
        BCard = new int[BCardNum];
        init(st, BCard, BCardNum);
        st = new StringTokenizer(br.readLine());
        CCard = new int[CCardNum];
        init(st, CCard, CCardNum);

        Arrays.sort(ACard);
        Arrays.sort(BCard);
        Arrays.sort(CCard);

        int answer = Integer.MAX_VALUE;
        for (int a : ACard) {
            for (int b : BCard) {
                for (int c : CCard) {
                    answer = Math.min(answer, Math.abs(Math.max(Math.max(a, b), c) - Math.min(Math.min(a, b), c)));
                }
            }
        }

        System.out.println(answer);
    }

    private static void init(StringTokenizer st, int[] card, int cardNum) {
        for (int i = 0; i < cardNum; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
    }
}