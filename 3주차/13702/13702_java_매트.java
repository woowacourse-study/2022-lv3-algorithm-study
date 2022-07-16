package me.hyeonic.algorithm.kstudy.week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Integer> alcohols = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            alcohols.add(scanner.nextInt());
        }

        long start = 1;
        long end = Integer.MAX_VALUE;

        while (start <= end) {
            long mid = (start + end) / 2;
            int count = 0;

            for (Integer alcohol : alcohols) {
                count += alcohol / mid;
            }

            if (count >= k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);
    }
}
