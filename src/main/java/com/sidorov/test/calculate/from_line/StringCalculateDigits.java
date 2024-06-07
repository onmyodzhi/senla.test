package com.sidorov.test.calculate.from_line;

public interface StringCalculateDigits {
    default int calculate(String str) {
        int sum = 0;

        for(char ch : str.toCharArray()){
            if(Character.isDigit(ch)){
                sum += Character.getNumericValue(ch);
            }
        }
        return sum;
    }
}
