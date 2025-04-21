package src;

import java.util.List;
import java.util.Scanner;

public class TouristApp {
    private TouristService service;
    private Scanner scanner;

    public TouristApp() {
        service = new TouristService();
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("===== Tourist Spot Recommender =====");

        while (true) {
            System.out.print("\nEnter your city name (or type 'exit' to quit): ");
            String city = scanner.nextLine().trim();

            if (city.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for using the Tourist Spot Recommender!");
                break;
            }

            if (city.isEmpty()) {
                System.out.println("⚠️ Please enter a valid city name.");
                continue;
            }
            showTouristSpotsForCity(city);
        }
        scanner.close();
    }

    private void showTouristSpotsForCity(String city) {
        List<TouristSpot> spots = service.getSpotsForCity(city);

        if (spots.isEmpty()) {
            System.out.println("❌ No tourist spots found for: " + city);
        } else {
            System.out.println("\n🌆 Popular tourist spots in " + city + ":");
            for (TouristSpot spot : spots) {
                System.out.println("- " + spot.getName());
                System.out.println("  📍 Located in: " + spot.getCityName() + ", " + spot.getStateName());
                System.out.println("  📝 Description: " + spot.getDescription() + "\n");
            }
        }
    }
}
