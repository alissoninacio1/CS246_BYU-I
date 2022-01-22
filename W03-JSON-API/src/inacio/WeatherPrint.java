package inacio;

/** a class to print all the things I need on screen
 * all the previous classes impact here
 * The forecast API for 5 days weather forecasts (getting forecasts for 3 hour increments during these 5 days)
 * is outlined here:
 * Rather than work with a single city, use a list of at least 5. (You can either allow the user to type them in,
 * or you can have them hard-coded into your Java code.)
 * For each city in the set, obtain the weather forecast.
 * Prepare a data structure that contains the city as well as the maximum temperature and the maximum wind speed
 * expected at any point in its upcoming 5-day forecast.
 * Sort the cities by maximum temperature and display the results.
 * Then, perform a separate sort, this time by maximum wind, speed and display the results.
 * */

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeatherPrint {
    private final List<String> locations;
    public List<WeatherConditions> selectedInformation = new ArrayList<>();

    public WeatherPrint(List<String> locations) {
        this.locations = locations;
    }

    public void forecastingCurrent() {
        //this i the url that I need to go
        // link + API key
        //api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=b8351742d2c65e58947f055cea7d4dfa

        String url = "https://api.openweathermap.org/data/2.5/weather";
        String charset = StandardCharsets.UTF_8.name();
        String apiKey = "b8351742d2c65e58947f055cea7d4dfa";
        String units = "metric";
        String query = "";


        //loop through the locations
        int count = 0;
        for (String location : locations) {
            System.out.printf("%nCity #%d is: %s%n", ++count, location);

            // how to get information from the server using try and catch
            try {
                query = String.format("q=%s&apiKey=%s&units=%s", URLEncoder.encode(location, charset),
                        URLEncoder.encode(apiKey, charset), URLEncoder.encode(units, charset));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            //in case of null points
            String responseBody = null;
            try {
                URLConnection connection = new URL(url + "?" + query).openConnection();
                connection.setRequestProperty("Accept-Charset", charset);
                InputStream response = connection.getInputStream();
                try (Scanner scanner = new Scanner(response)) {
                    responseBody = scanner.useDelimiter("\\A").next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            //Using a new obj
            // to Deserialize the Json file
            Gson gson = new Gson();
            WeatherConditions wc = gson.fromJson(responseBody, WeatherConditions.class);

            System.out.println(wc.toString());
        }
        System.out.println("End of data for 30 days.");
    }

    //forecast per locations
    public void forecasting30() {
        String url = "https://api.openweathermap.org/data/2.5/weather";
        String charset = StandardCharsets.UTF_8.name();
        String apiKey = "b8351742d2c65e58947f055cea7d4dfa";
        String units = "metric";
        String query = "";

        // loop through the locations
        for (String location : locations) {

            //  Get server info
            try {
                query = String.format("q=%s&apiKey=%s&units=%s", URLEncoder.encode(location, charset),
                        URLEncoder.encode(apiKey, charset), URLEncoder.encode(units, charset));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            String responseBodyForecast = null;
            try {
                URLConnection connection = new URL(url + "?" + query).openConnection();
                connection.setRequestProperty("Accept-Charset", charset);
                InputStream responseForecast = connection.getInputStream();
                try (Scanner scanner = new Scanner(responseForecast)) {
                    responseBodyForecast = scanner.useDelimiter("\\A").next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Deserialize the Json file into the forecast class
            Gson gsonForecast = new Gson();
            WeatherForecast wf = gsonForecast.fromJson(responseBodyForecast, WeatherForecast.class);

            selectedInformation = wf.forecastingFiveDays();

            System.out.format("%nCITY: %s%n", wf.toString());
            wf.retrieveForecast();
            System.out.printf("This was 30 days of forecast for %s. %n%n", wf.city.get("name"));
        }
        System.out.println("End of forecasted data per 30 days per location.");
    }

    public void forecastingMaxTemperature(int i) {
        if (i > 45)
            System.out.println("Impossible retrieve more than 45 unities.");
        else {
            System.out.printf("The mas temperature is %d", i);;
        }
    }
}