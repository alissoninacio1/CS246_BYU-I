package inacio;
/**
 * CREATE A CLASS TO STORE THE DATA
 * There is a lot of information in the responses we will get back,
 * but for this assignment we only care about some of it.
 * As we did in the teach assignment, we'll be creating a class to hold just the data we're interested in.
 */

import java.util.HashMap;
import java.util.Map;
import com.google.gson.annotations.SerializedName;

public class WeatherConditions {
    private int id;
    private String name;
    private Map<String, Float> wind;

    @SerializedName("main")
    private Map<String, Float> measurements;

    public WeatherConditions() {
        this.id = id;
        this.name = name;

        this.measurements = new HashMap<>();
        this.wind = new HashMap<>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Float> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(Map<String, Float> measurements) {
        this.measurements = measurements;
    }

    public Map<String, Float> getWind() {
        return wind;
    }

    public void setWind(Map<String, Float> wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "WeatherConditions{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", measurements=" + measurements.get("temp") +
                '}';
    }
}
