package me.jmlab.interview.algorithm.bubblesort;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        int[] input;
        try (Scanner scanner = new Scanner(System.in)) {
            int size = scanner.nextInt();

            input = new int[size];

            for (int i = 0; i < size; i++) {
                input[i] = scanner.nextInt();
            }
        }

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length - 1; j++) {
                int tmp;
                if (input[j] > input[j + 1]) {
                    tmp = input[j + 1];
                    input[j + 1] = input[j];
                    input[j] = tmp;
                }
            }
        }

        System.out.print(Arrays.stream(input).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
