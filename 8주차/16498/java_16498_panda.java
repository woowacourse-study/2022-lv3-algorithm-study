package algorithm_study.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class java_16498_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int aNum = Integer.parseInt(st.nextToken());
        int bNum = Integer.parseInt(st.nextToken());
        int cNum = Integer.parseInt(st.nextToken());

        TreeSet<Integer> A = new TreeSet<>();
        TreeSet<Integer> B = new TreeSet<>();
        TreeSet<Integer> C = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aNum; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bNum; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cNum; i++) {
            C.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 100_000_000;

        for (int a : A) {
            Integer bCeil = B.ceiling(a);
            if (Objects.nonNull(bCeil)) {
                if (C.subSet(a, true, bCeil, true).isEmpty()) {
                    Integer cCeil = C.ceiling(bCeil);
                    if (Objects.nonNull(cCeil)) {
                        answer = Math.min(answer, cCeil - a);
                    }

                    Integer cFloor = C.floor(a);
                    if (Objects.nonNull(cFloor)) {
                        answer = Math.min(answer, bCeil - cFloor);
                    }
                } else {
                    answer = Math.min(answer, bCeil - a);
                }
            }

            Integer bFloor = B.floor(a);
            if (Objects.nonNull(bFloor)) {
                if (C.subSet(bFloor, true, a, true).isEmpty()) {
                    Integer cCeil = C.ceiling(a);
                    if(Objects.nonNull(cCeil)){
                        answer = Math.min(answer, cCeil - bFloor);
                    }

                    Integer cFloor = C.floor(bFloor);
                    if(Objects.nonNull(cFloor)){
                        answer = Math.min(answer , a - cFloor);
                    }

                } else {
                    answer = Math.min(answer, a - bFloor);
                }
            }
        }
        System.out.println(answer);
    }
}
