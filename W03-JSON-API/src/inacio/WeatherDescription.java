package inacio;

public class WeatherDescription {
    private String description;

    public WeatherDescription (String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "WeatherDescription{" +
                "description='" + description + '\'' +
                '}';
    }
}