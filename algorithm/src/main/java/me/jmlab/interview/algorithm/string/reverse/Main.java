package me.jmlab.interview.algorithm.string.reverse;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        char[] input;
        try (Scanner scanner = new Scanner(System.in)) {
            input = scanner.next().toCharArray();
        }

        char tmp = '0';
        for (int i = 0; i < input.length / 2; i++) {
            tmp = input[i];
            input[i] = input[input.length - i - 1];
            input[input.length - i - 1] = tmp;
        }

        System.out.print(input);
    }
}
