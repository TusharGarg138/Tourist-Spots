package src;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/tourism";
    private static final String USER = "root";
    private static final String PASSWORD = "yourpassword"; // Update this

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        }
    }

    public List<TouristSpot> getSpotsByCity(String cityName) {
        List<TouristSpot> spots = new ArrayList<>();
        String query = """
            SELECT ts.name AS spot_name, ts.description, c.name AS city_name, s.name AS state_name
            FROM tourist_spots ts
            JOIN cities c ON ts.city_id = c.id
            JOIN states s ON c.state_id = s.id
            WHERE c.name = ?
        """;

        try (
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, cityName);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String spotName = rs.getString("spot_name");
                String description = rs.getString("description");
                String city = rs.getString("city_name");
                String state = rs.getString("state_name");

                spots.add(new TouristSpot(spotName, description, city, state));
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }

        return spots;
    }
}
