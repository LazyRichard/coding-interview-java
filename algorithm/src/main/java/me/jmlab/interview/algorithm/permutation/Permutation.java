package me.jmlab.interview.algorithm.permutation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;

public class Permutation<T> implements BiFunction<List<T>, Integer, Collection<List<T>>> {

    private List<List<T>> result;

    private List<T> input;

    private int[] picks;

    private int r;

    @Override
    public Collection<List<T>> apply(List<T> input, Integer r) {
        Objects.requireNonNull(input, "input should not be a null");
        Objects.requireNonNull(r, "r should not be a null");

        this.result = new ArrayList<>();
        this.input = input;
        this.r = r;
        this.picks = new int[r];

        calculate(0);

        return result;
    }

    private void calculate(int depth) {
        if (depth == r) {
            List<T> lst = new ArrayList<>();
            for (int p : picks) {
                lst.add(input.get(p));
            }

            result.add(lst);
            return;
        }

        for (int i = 0; i < input.size(); i++) {
            picks[depth] = i;
            calculate(depth + 1);
        }
    }
}
