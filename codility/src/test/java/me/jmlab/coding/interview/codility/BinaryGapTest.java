package me.jmlab.coding.interview.codility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BinaryGapTest {

    static Stream<Arguments> methodSource() {
        return Stream.of(Arguments.of(1041, 5), Arguments.of(9, 2), Arguments.of(529, 4), Arguments.of(20, 1));
    }

    private BinaryGap binaryGap = new BinaryGap();

    @ParameterizedTest
    @MethodSource("methodSource")
    void test(int n, int expected) {
        int actual = binaryGap.solution(n);

        assertEquals(expected, actual);
    }
}
