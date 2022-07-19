package study.coding.test.backjoon.week_3.p_2_17123;

import static java.lang.Integer.parseInt;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class P {

    final LinkedList<Case> cases = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final P p = new P();
        out.println(p.solve(br.readLine()));
        br.close();
    }

    public String solve(String initInput) {
        final StringTokenizer st = new StringTokenizer(initInput, "\n");
        final String totalSize = st.nextToken();

        makeMatrix(st);

        StringBuffer result = new StringBuffer();

        for (final Case caze : cases) {
            // op
            for (int i = 0; i < caze.opSize; i++) {
                final int r1 = caze.op[i][0];
                final int c1 = caze.op[i][1];

                final int r2 = caze.op[i][2];
                final int c2 = caze.op[i][3];

                final int v = caze.op[i][4];

                for (int r = r1; r <= r2; r++) {
                    for (int c = c1; c <= c2; c++) {
                        caze.matrix[r][c] += v;
                    }
                }
            }

            int[] rowSum = new int[caze.matrixSize];
            int[] colSum = new int[caze.matrixSize];

            for (int r = 0; r < caze.matrixSize; r++) {
                for (int c = 0; c < caze.matrixSize; c++) {
                    colSum[r] += caze.matrix[r][c];
                }
            }

            for (int c = 0; c < caze.matrixSize; c++) {
                for (int r = 0; r < caze.matrixSize; r++) {
                    rowSum[c] += caze.matrix[r][c];
                }
            }

            final String colSumStr = Arrays.stream(colSum)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));

            final String rowSumStr = Arrays.stream(rowSum)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));

            result.append(colSumStr);
            result.append("\n");
            result.append(rowSumStr);
            result.append("\n");
        }

        final int last = result.lastIndexOf("\n");
        result.delete(last, result.length());

        return result.toString();
    }

    private void makeMatrix(final StringTokenizer st) {
        while (st.hasMoreTokens()) {
            String[] matrixSize_opSize = st.nextToken().split(" ");

            final int matrixSize = parseInt(matrixSize_opSize[0]);
            final int opSize = parseInt(matrixSize_opSize[1]);
            final Case caze = new Case();
            cases.add(caze);

            // make matrix
            final int[][] matrix = new int[matrixSize][matrixSize];

            for (int r = 0; r < matrixSize; r++) {
                final String[] row = st.nextToken().split(" ");
                for (int c = 0; c < matrixSize; c++) {
                    matrix[r][c] = parseInt(row[c]);
                }
            }
            caze.matrix = matrix;
            caze.matrixSize = matrixSize;

            // make op
            caze.op = new int[opSize][5];
            caze.opSize = opSize;
            for (int i = 0; i < opSize; i++) {
                final String[] opStr = st.nextToken().split(" ");

                caze.op[i][0] = parseInt(opStr[0]) - 1; // r1
                caze.op[i][1] = parseInt(opStr[1]) - 1; // c1

                caze.op[i][2] = parseInt(opStr[2]) - 1; // r2
                caze.op[i][3] = parseInt(opStr[3]) - 1; // c2

                caze.op[i][4] = parseInt(opStr[4]); // v
            }
        }
    }

    private static class Case {
        int[][] matrix;
        int[][] op;
        int matrixSize;
        int opSize;

        @Override
        public String toString() {
            return "Case{" +
                    "matrix=" + Arrays.deepToString(matrix) +
                    ", op=" + Arrays.deepToString(op) +
                    '}';
        }
    }
}
