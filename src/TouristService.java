package src;

import java.util.List;

public class TouristService {
    private DatabaseManager dbManager;

    // Constructor
    public TouristService() {
        dbManager = new DatabaseManager();
    }

    // Gets tourist spots for a given city by calling the DB layer
    public List<TouristSpot> getSpotsForCity(String city) {
        return dbManager.getSpotsByCity(city);
    }
}
