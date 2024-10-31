package javaConsole;

public class FutureDateException extends Exception {
    public FutureDateException() {
        super("Date of Birth cannot be a future date.");
    }
} 
