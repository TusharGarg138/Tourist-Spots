package src;

import java.util.List;

public class TouristService {
    private DatabaseManager dbManager;

    public TouristService() {
        dbManager = new DatabaseManager();
    }

    public List<TouristSpot> getSpotsForCity(String city)
            throws CityNotFoundException, DatabaseConnectionException, EmptyInputException {

        if (city == null || city.trim().isEmpty()) {
            throw new EmptyInputException();
        }

        List<TouristSpot> spots = dbManager.getSpotsByCity(city.trim());

        if (spots.isEmpty()) {
            throw new CityNotFoundException(city);
        }

        return spots;
    }
}
