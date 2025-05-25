package me.jmlab.coding.interview.leetcode.leet133;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import me.jmlab.coding.interview.leetcode.common.Node;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    static Stream<Arguments> methodSource() {

        return Stream.of(Arguments.of(convert(List.of(List.of(2, 4), List.of(1, 3), List.of(2, 4), List.of(1, 3)))));
    }

    private static final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("methodSource")
    void test(Node node) {
        Node actual = solution.cloneGraph(node);

        assertNotNull(actual);
    }

    private static Node convert(List<List<Integer>> definitions) {
        Map<Integer, Node> map = new HashMap<>();

        for (int i = 0; i < definitions.size(); i++) {
            Node node = map.getOrDefault(i + 1, new Node(i + 1));
            map.put(i + 1, node);

            List<Integer> definition = definitions.get(i);

            for (int d : definition) {
                Node link = map.getOrDefault(d, new Node(d));
                map.put(d, link);

                node.neighbors.add(link);
            }
        }

        return map.get(1);
    }
}
