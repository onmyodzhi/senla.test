package com.sidorov.test.calculate.from_line;

import java.util.concurrent.CompletableFuture;

public class StringCalculateImp implements StringCalculateDigits {
    public int calculateSumOfDigitsRecursively(String str) {
        return calculateSumOfDigitsRecursively(str, 0);
    }

    public int calculateSingleThreadSumOfDigits(String input) {
        return calculate(input);
    }

    public int calculateParallelSumOfDigits(String input) {
        if (input.length() <= 500) {
            return calculate(input);
        }

        int mid = input.length() / 2;
        String partOne = input.substring(0, mid);
        String partTwo = input.substring(mid);

        CompletableFuture<Integer> futureForPartOne = CompletableFuture.supplyAsync(() -> calculate(partOne));
        CompletableFuture<Integer> futureForPartTwo = CompletableFuture.supplyAsync(() -> calculate(partTwo));

        return futureForPartOne.join() + futureForPartTwo.join();
    }

    private int calculateSumOfDigitsRecursively(String str, int depth) {

        if (str.isBlank()) return 0;

        if (str.length() < 500 || depth >= 2) return calculate(str);

        int midline = str.length() / 2;
        String parallelOne = str.substring(0, midline);
        String parallelTwo = str.substring(midline);

        CompletableFuture<Integer> futureForPartOne = CompletableFuture.supplyAsync(() -> calculateSumOfDigitsRecursively(parallelOne, 1 + depth));
        CompletableFuture<Integer> futureForPartTwo = CompletableFuture.supplyAsync(() -> calculateSumOfDigitsRecursively(parallelTwo, 1 + depth));

        return futureForPartOne.join() + futureForPartTwo.join();
    }
}
