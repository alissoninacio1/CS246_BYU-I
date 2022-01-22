package inacio;

/**
 * In the previous part, we obtained current conditions for a given city.
 * In this part, we will request forecasts for a city rather than simply its current conditions.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherForecast {
    protected Map<String, Object> city;
    private List<WeatherForecastItem> list;
    private List<WeatherConditions> weather;


    int countForDays = 0;

    public WeatherForecast() {
        this.city = new HashMap<>();
        this.list = new ArrayList<>();
        this.weather = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format(
                "Name = %s%n"
                , city.get("name")
        );
    }

    public void retrieveForecast() {
        for (WeatherForecastItem item : list)
            System.out.println("Forecast per day " + ++countForDays + ":\n" + item.toString());
    }

    public List<WeatherConditions> forecastingFiveDays() {
        int limit;
        for (WeatherForecastItem item : list) {
            WeatherConditions newItem = new WeatherConditions();
            newItem.setName(item.toString());
            newItem.setMeasurements(item.measurements);
            newItem.setWind(item.wind);

            weather.add(newItem);
        }
        return weather;
    }
}