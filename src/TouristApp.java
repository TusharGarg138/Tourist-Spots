package src;

import java.util.List;
import java.util.Scanner;

public class TouristApp {
    private TouristService service;

    public TouristApp() {
        service = new TouristService();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("🌍 Welcome to the Tourist Spot Recommendation System!");

        while (true) {
            System.out.print("\n🏙️ Enter a city name (or type 'exit' to quit): ");
            String city = scanner.nextLine();

            if (city.equalsIgnoreCase("exit")) {
                System.out.println("👋 Thank you for using the system. Safe travels!");
                break;
            }

            showTouristSpotsForCity(city);
        }

        scanner.close();
    }

    private void showTouristSpotsForCity(String city) {
        try {
            List<TouristSpot> spots = service.getSpotsForCity(city);
            System.out.println("\n🌆 Popular tourist spots in " + city + ":");
            for (TouristSpot spot : spots) {
                System.out.println("- " + spot.getName());
                System.out.println("  📍 Located in: " + spot.getCityName() + ", " + spot.getStateName());
                System.out.println("  📝 Description: " + spot.getDescription() + "\n");
            }
        } catch (EmptyInputException | CityNotFoundException | DatabaseConnectionException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("❗ An unexpected error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new TouristApp().run();
    }
}
