package com.sidorov.test.exceptions;

public class EnteredNumberIsNegativeException extends RuntimeException{
    public EnteredNumberIsNegativeException() {
        super("Entered number is negative or zero");
    }
}
