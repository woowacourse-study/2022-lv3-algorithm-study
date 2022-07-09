import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static study.coding.test.backjoon.week_1.Sol_1_17362.풀이_2;

class Sol_1_17362Test {

    @ParameterizedTest
    @CsvSource(value = {
            "1-1",
            "2-2",
            "3-3",
            "4-4",
            "5-5",
            "6-4",
            "7-3",
            "8-2",
            "9-1",
            "10-2",
            "11-3",
            "12-4",
            "13-5",
            "1000-2"
    }, delimiter = '-')
    void wqewqe_(int in, int out) {
        Integer result = 풀이_2(in);
        assertThat(result).isEqualTo(out);
    }
}
