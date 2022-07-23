import static java.lang.Integer.parseInt;
import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

class P {

    /**
     * fail
     */

    public static void main(String[] args) {
        final P p = new P();
        final Reader reader = new InputStreamReader(System.in);
        String output = p.solve(reader);
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
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length - 1; i++) {
            max = max(max, dfs(nums, i, 0));
        }

        return max + "";
    }

    private int dfs(final int[] nums, final int index, int sum) {

        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("index = " + index);
        System.out.println("sum = " + sum);

        if (nums.length == 2 || (index == 0 || index >= nums.length - 1)) {
            return sum;
        }

        sum += nums[index - 1] * nums[index + 1];

        for (int i = 1; i < nums.length - 1; i++) {
            final int[] cherryKill = cherryKill(nums, i);
            for (int j = 0; j < cherryKill.length; j++) {
                sum = max(sum, dfs(cherryKill, j, sum));
            }
        }

        return sum;
    }

    private static int[] cherryKill(final int[] arr, final int index) {
        final int[] copyArr = Arrays.copyOfRange(arr, 0, index);
        final int[] copyArr2 = Arrays.copyOfRange(arr, index + 1, arr.length);

        final int[] result = concatArray(copyArr, copyArr2);
        return result;
    }

    private static int[] concatArray(final int[] copyArr, final int[] copyArr2) {
        final int[] result = Arrays.copyOf(copyArr, copyArr.length + copyArr2.length);
        System.arraycopy(copyArr2, 0, result, copyArr.length, copyArr2.length);
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
