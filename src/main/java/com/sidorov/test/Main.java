package com.sidorov.test;

import com.sidorov.test.calculate.from_line.StringCalculateImp;
import com.sidorov.test.calculate.from_integer.CalculateInteger;
import com.sidorov.test.word_processing.WordProcessor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //taskOne();
        //taskTwo();
        taskTree();
    }

    private static void taskOne() {
        String input = "qwer-1.1.1.1-.1-1-11" + "qwer-1.1.1.1-.1-1-11".repeat(1_000_000);
        long startTime, endTime;

        startTime = System.nanoTime();
        int singleThreadResult = new StringCalculateImp().calculateSingleThreadSumOfDigits(input);
        endTime = System.nanoTime();
        System.out.println("Однопоточный результат: " + singleThreadResult + ", время: " + (endTime - startTime) / 1_000_000 + " мс");

        startTime = System.nanoTime();
        int parallelResult = new StringCalculateImp().calculateParallelSumOfDigits(input);
        endTime = System.nanoTime();
        System.out.println("Параллельный результат (без рекурсии): " + parallelResult + ", время: " + (endTime - startTime) / 1_000_000 + " мс");

        startTime = System.nanoTime();
        int recursiveParallelResult = new StringCalculateImp().calculateSumOfDigitsRecursively(input);
        endTime = System.nanoTime();
        System.out.println("Параллельный результат (рекурсия): " + recursiveParallelResult + ", время: " + (endTime - startTime) / 1_000_000 + " мс");
    }

    private static void taskTwo() {
        System.out.println(new CalculateInteger().getPrimeMultipliers());
    }

    private static void taskTree() {
        WordProcessor wordProcessor = new WordProcessor();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите текс: ");
            String text = scanner.nextLine();
            System.out.println(wordProcessor.countNumberOfVowelsInText(text));
            wordProcessor.printSortedToVowels(text);
        }
    }
}