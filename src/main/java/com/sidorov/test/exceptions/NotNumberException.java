package com.sidorov.test.exceptions;

public class NotNumberException extends RuntimeException{
    public NotNumberException() {
        super("Entered data is`nt a number");
    }
}
