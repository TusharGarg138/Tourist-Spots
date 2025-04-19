package src;

import java.util.List;
import java.util.Scanner;

public class TouristApp {
    private TouristService service;
    private Scanner scanner;

    // Constructor: initializes service and scanner
    public TouristApp() {
        service = new TouristService();
        scanner = new Scanner(System.in);
    }

    // Main app logic
    public void run() {
        System.out.println("===== Tourist Spot Recommender =====");

        boolean running = true;

        while (running) {
            System.out.print("\nEnter your city name (or type 'exit' to quit): ");
            String city = scanner.nextLine().trim();

            if (city.equalsIgnoreCase("exit")) {
                running = false;
                System.out.println("Thank you for using the Tourist Spot Recommender!");
            } else if (city.isEmpty()) {
                System.out.println("⚠️ Please enter a valid city name.");
            } else {
                showTouristSpotsForCity(city);
            }
        }

        scanner.close();
    }

    // Fetches and displays tourist spots for the entered city
    private void showTouristSpotsForCity(String city) {
        List<TouristSpot> spots = service.getSpotsForCity(city);

        if (spots.isEmpty()) {
            System.out.println("❌ No tourist spots found for city: " + city);
        } else {
            System.out.println("\n🌆 Popular tourist spots in " + city + ":");
            for (TouristSpot spot : spots) {
                System.out.println("- " + spot.getName());
                System.out.println("  📍 " + spot.getDescription() + "\n");
            }
        }
    }
}
