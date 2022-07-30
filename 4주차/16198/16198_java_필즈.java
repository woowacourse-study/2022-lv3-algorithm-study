package study.coding.test.backjoon.week_4.p_2_16198;

import static java.lang.Integer.parseInt;
import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

class Main {

    /**
     * pass
     */
    public static void main(String[] args) {
        final Main main = new Main();
        final Reader reader = new InputStreamReader(System.in);
        String output = main.solve(reader);
        System.out.println(output);
        close(reader);
    }

    public String solve(final Reader reader) {
        final BufferedReader br = new BufferedReader(reader);
        final int N = parseInt(read(br));
        final String[] initInputs = readStrArr(br);
        final int[] nums = new int[initInputs.length];

        for (int i = 0; i < initInputs.length; i++) {
            nums[i] = parseInt(initInputs[i]);
        }

        // dfs
        int maxVal = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length - 1; i++) {
            maxVal = max(maxVal, dfs(nums, i, 0));
        }

        return maxVal + "";
    }

    private int dfs(final int[] nums, final int index, int sum) {

/*
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("index = " + index);
        System.out.println("sum = " + sum);
*/

        final int energy = nums[index - 1] * nums[index + 1];
        sum += energy;
        final int[] subArr = cherryKill(nums, index);

        int maxVal = Integer.MIN_VALUE;
        for (int j = 1; j < subArr.length - 1; j++) {
            maxVal = max(maxVal, dfs(subArr, j, sum));
        }

        if (subArr.length == 2) {
            return sum;
        }

        return maxVal;
    }

    private static int[] cherryKill(final int[] arr, final int index) {
        final int[] deepCopyLeft = Arrays.copyOfRange(arr, 0, index);
        final int[] deepCopyRight = Arrays.copyOfRange(arr, index + 1, arr.length);

        final int[] result = concatArray(deepCopyLeft, deepCopyRight);
        return result;
    }

    private static int[] concatArray(final int[] deepCopyLeft, final int[] deepCopyRight) {
        final int[] result = Arrays.copyOf(deepCopyLeft, deepCopyLeft.length + deepCopyRight.length);
        System.arraycopy(deepCopyRight, 0, result, deepCopyLeft.length, deepCopyRight.length);
        return result;
    }

    private String[] readStrArr(final BufferedReader br) {
        return read(br).split(" ");
    }

    private String read(final BufferedReader br) {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void close(final Reader reader) {
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
