import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/tourism_planner";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public List<TouristSpot> getTouristSpots(String location) throws SQLException {
        List<TouristSpot> spots = new ArrayList<>();

        String query = """
                SELECT ts.name, c.city_name AS city, s.state_name AS state, ts.description
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
                        rs.getString("name"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("description")
                ));
            }
        }
        return spots;
    }
}
