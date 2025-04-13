package src;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/tourism_planner";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "YOUR_DBMS_PASSWORD"; // replace with your actual password

    public List<TouristSpot> getTouristSpots(String location) throws SQLException {
        List<TouristSpot> spots = new ArrayList<>();

        String query = """
            SELECT ts.name AS spot_name, c.city_name, s.state_name, ts.description
            FROM tourist_spots ts
            JOIN cities c ON ts.city_id = c.city_id
            JOIN states s ON c.state_id = s.state_id
            WHERE c.city_name LIKE ? OR s.state_name LIKE ?
        """;

        
        return spots;
    }
}