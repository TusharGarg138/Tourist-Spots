package src;

public class CityNotFoundException extends Exception {
    public CityNotFoundException(String city) {
        super("❌ No tourist spots found for city: " + city);
    }
}
