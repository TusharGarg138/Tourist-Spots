package src;

public class DatabaseConnectionException extends Exception {
    public DatabaseConnectionException(String message) {
        super("🚫 Database connection error: " + message);
    }
}
