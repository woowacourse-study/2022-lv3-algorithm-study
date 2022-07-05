package PS;

import java.util.Scanner;

public class Camping {

    //캠핑장을 연속한 P일 중, L일동안만 사용할 수 있다.
    // V일짜리 휴가를 시작했다면 며칠동안 캠핑장을 이용가능?
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        for (int i = 1; ; i++) {
            int l = s.nextInt();
            int p = s.nextInt();
            int v = s.nextInt();

            if (isLast(l, p, v)) {
                break;
            }
            findCampingDay(i, l, p, v);
        }


    }

    private static boolean isLast(int l, int p, int v) {
        return l == 0 && p == 0 & v == 0;
    }

    private static void findCampingDay(int index, int l, int p, int v) {
        int campingDay = (v / p) * l + Math.min((v % p), l);
        System.out.println("Case " + index+": " + campingDay);
    }

}
