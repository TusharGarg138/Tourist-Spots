package src;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/tourism";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public List<TouristSpot> getSpotsByCity(String cityName) throws DatabaseConnectionException {
        List<TouristSpot> spots = new ArrayList<>();

        String query = """
            SELECT ts.name AS spot_name, ts.description, c.city_name AS city_name, s.state_name AS state_name
            FROM tourist_spots ts
            JOIN cities c ON ts.city_id = c.city_id
            JOIN states s ON c.state_id = s.state_id
            WHERE c.city_name = ?
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

        } catch (SQLNonTransientConnectionException e) {
            throw new DatabaseConnectionException("MySQL service might not be running.");
        } catch (SQLException e) {
            throw new DatabaseConnectionException(e.getMessage());
        }

        return spots;
    }
}
