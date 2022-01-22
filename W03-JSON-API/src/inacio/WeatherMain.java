package inacio;

//a weather main class to print on screen and run the program

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeatherMain {

    public static void main(String[] args) {
        System.out.println("Local Conditions");
        List<String> locations = new ArrayList<>();
        inputLocations(locations);

        WeatherPrint wp= new WeatherPrint(locations);
        // Get current conditions
        wp.forecastingCurrent();

        System.out.println("Forecasts:");
        wp.forecasting30();  // Get the forecast for each location for 30 days
        wp.forecastingMaxTemperature(5);
    }

    //list of cities
    private static void inputLocations(List<String> locations) {
        Scanner input = new Scanner( System.in );

        System.out.println("How many locations do you want to know?");
        int locationsAmount = input.nextInt();
        System.out.format("%nEntered %d location names:%n", locationsAmount);

        //input names of location
        for (int i = 0; i < locationsAmount; i++)
            locations.add(input.nextLine());

        System.out.printf("%nEntered locations are:\n");
        for(String location : locations ) {
            if(!location.isBlank())
                System.out.printf(" %s%n", location);
        }
    }
}