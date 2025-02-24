package me.jmlab.interview.algorithm.combination;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;

public class Combination<T> implements BiFunction<List<T>, Integer, Collection<List<T>>> {

    private final boolean allowDuplicate;

    private List<T> input;

    private List<List<T>> result;

    private int r;

    private boolean[] visited;

    private int[] picks;

    public Combination(boolean allowDuplicate) {
        this.allowDuplicate = allowDuplicate;
    }

    public Combination() {
        this(false);
    }

    @Override
    public Collection<List<T>> apply(List<T> input, Integer r) {
        this.input = input;
        this.result = new ArrayList<>();
        this.r = r;
        this.picks = new int[r];
        this.visited = new boolean[input.size()];

        calculate(0);

        return result;
    }

    private void calculate(int depth) {
        if (depth == r) {
            List<T> el = new ArrayList<>();
            for (int p : picks) {
                el.add(input.get(p));
            }
            result.add(el);
            return;
        }

        for (int i = 0; i < input.size(); i++) {
            if ((!allowDuplicate) && visited[i]) continue;

            visited[i] = true;
            picks[depth] = i;
            calculate(depth + 1);
            visited[i] = false;
        }
    }
}
