package me.jmlab.interview.algorithm.permutation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PermutationTest {

    public static Stream<Arguments> provider() {
        return Stream.of(Arguments.of(
                Arrays.asList(3, 2, 1),
                Arrays.asList(
                        Arrays.asList(3, 3),
                        Arrays.asList(3, 2),
                        Arrays.asList(3, 1),
                        Arrays.asList(2, 3),
                        Arrays.asList(2, 2),
                        Arrays.asList(2, 1),
                        Arrays.asList(1, 3),
                        Arrays.asList(1, 2),
                        Arrays.asList(1, 1))));
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void test(List<Integer> input, List<List<Integer>> expected) {
        var perm = new Permutation<Integer>();

        var actual = perm.apply(input, 2);

        Assertions.assertEquals(expected, actual);
    }
}
