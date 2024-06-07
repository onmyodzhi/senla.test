package com.sidorov.test.calculate.from_integer;

import com.sidorov.test.exceptions.EnteredNumberIsNegativeException;
import com.sidorov.test.exceptions.NotNumberException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculateInteger {
    public List<Integer> getPrimeMultipliers() {

        return findPrimeMultipliers(getValidInteger());
    }

    private int getValidInteger() {
        String number;
        int validNumber;

        System.out.print("Введите целое число: ");

        try (Scanner scanner = new Scanner(System.in)) {
            number = scanner.nextLine();
            validNumber = Integer.parseInt(number);
        }catch (NumberFormatException e) {
            throw new NotNumberException();
        }

        if (validNumber <= 0) throw new EnteredNumberIsNegativeException();

        return validNumber;
    }

    private List<Integer> findPrimeMultipliers(int number) {
        List<Integer> primes = new ArrayList<Integer>();

        for (int i = 2; i <= Math.sqrt(number); i++) {
            while (number % i == 0) {
                primes.add(i);
                number /= i;
            }
        }

        if (number > 2) primes.add(number);

        return primes;
    }
}
