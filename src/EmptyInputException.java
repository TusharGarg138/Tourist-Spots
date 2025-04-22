package src;

public class EmptyInputException extends Exception {
    public EmptyInputException() {
        super("⚠️ City name cannot be empty. Please enter a valid city name.");
    }
}
