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

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, "%" + location + "%");
            stmt.setString(2, "%" + location + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                spots.add(new TouristSpot(
                    rs.getString("spot_name"),
                    rs.getString("city_name"),
                    rs.getString("state_name"),
                    rs.getString("description")
                ));
            }
        }
        return spots;
    }
}