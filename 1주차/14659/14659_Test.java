import static org.assertj.core.api.Assertions.assertThat;
import static study.coding.test.backjoon.week_1.Sol_4_14659.solve;

import org.junit.jupiter.api.Test;

class Sol_4_14659Test {

    /**
     * 7
     * 6 4 10 2 5 7 11
     */
    @Test
    void test1() {
        assertThat(solve(7, new int[]{6, 4, 10, 2, 5, 7, 11})).isEqualTo(3);
        assertThat(solve(6, new int[]{5, 8, 3, 4, 1, 7})).isEqualTo(4);
    }
}