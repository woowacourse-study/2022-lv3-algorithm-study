package study.coding.test.backjoon.week_2;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;
import static study.coding.test.backjoon.week_2.Sol_3_23827_5.solve;

import java.io.IOException;
import java.io.StringReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Sol_3_23827_5Test {

    @DisplayName("test")
    @Test
    void test() throws IOException {
        String input =
                "3\n"
                        + "1 2 3";
        StringReader reader = new StringReader(input);
        String output = solve(reader);
        out.println("output = " + output);

        assertThat(output).isEqualTo("11");
    }

    @DisplayName("test - 2")
    @Test
    void test_2() throws IOException {
        String input =
                "4\n"
                        + "1 2 3 4";

        StringReader reader = new StringReader(input);
        String output = solve(reader);
        out.println("output = " + output);

        assertThat(output).isEqualTo("35");
    }

    @DisplayName("test - 3")
    @Test
    void test_3() throws IOException {
        String input =
                "3\n"
                        + "2 3 4";
        StringReader reader = new StringReader(input);
        String output = solve(reader);
        out.println("output = " + output);

        assertThat(output).isEqualTo("26");
    }

    @DisplayName("test 4")
    @Test
    void test_4() throws IOException {
        String input =
                "4\n"
                        + "2 5 8 11";
        StringReader reader = new StringReader(input);
        String output = solve(reader);
        out.println("output = " + output);

        assertThat(output).isEqualTo("231");
    }

    @DisplayName("test 5")
    @Test
    void test_5() throws IOException {
        String input =
                "5\n"
                        + "1 2 3 4 5";
        StringReader reader = new StringReader(input);
        String output = Sol_3_23827_3.solve(reader);
        out.println("output = " + output);

        assertThat(output).isEqualTo("85");
    }

    @DisplayName("no test")
    @Test
    void no_test() throws IOException {
        String input =
                "6\n"
                        + "123123 5006 60007 423123 234234 489489";
        StringReader reader = new StringReader(input);
        String output = solve(reader);
        out.println("output = " + output);
    }
}