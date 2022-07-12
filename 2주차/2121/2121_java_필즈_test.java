package study.coding.test.backjoon.week_2;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.StringReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Sol_2_2121_5Test {

    @DisplayName("test")
    @Test
    void test_() throws IOException {
        String input =
                "6\n"
                        + "2 3\n"
                        + "0 0\n"
                        + "2 0\n"
                        + "2 3\n"
                        + "0 3\n"
                        + "4 0\n"
                        + "4 3";

        StringReader reader = new StringReader(input);
        String output = Sol_2_2121_5.solve(reader);

        out.println("output = " + output);
        assertThat(output).isEqualTo("2");
    }
}