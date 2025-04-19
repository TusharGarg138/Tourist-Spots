package src;

public class TouristSpot {
    private String name;
    private String description;

    // Constructor
    public TouristSpot(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for description
    public void setDescription(String description) {
        this.description = description;
    }

    // Override toString() for easy printing
    @Override
    public String toString() {
        return name + " - " + description;
    }
}
