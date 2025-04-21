package src;

public class TouristSpot {
    private String name;
    private String description;
    private String cityName;
    private String stateName;

    public TouristSpot(String name, String description, String cityName, String stateName) {
        this.name = name;
        this.description = description;
        this.cityName = cityName;
        this.stateName = stateName;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCityName() {
        return cityName;
    }

    public String getStateName() {
        return stateName;
    }
}
