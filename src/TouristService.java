package src;

import java.util.List;

public class TouristService {
    private DatabaseManager dbManager;

    public TouristService() {
        dbManager = new DatabaseManager();
    }

    public List<TouristSpot> getSpotsForCity(String city) {
        return dbManager.getSpotsByCity(city);
    }
}
