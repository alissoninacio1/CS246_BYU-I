package inacio;

import java.util.Scanner;

public class SwitchCalculatorTest {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner input = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\nWelcome to this simple Java calculator !");
            System.out.print("Operation (add, subtract, multiply, divide, reset, exit): ");
            choice = input.nextLine();
            float value;

            switch (choice) {
                case "add" -> {
                    System.out.print("Enter a value: ");
                    value = Float.parseFloat(input.nextLine());
                    calc.add(value);
                }
                case "subtract" -> {
                    System.out.print("Enter a value: ");
                    value = Float.parseFloat(input.nextLine());
                    calc.subtract(value);
                }
                case "multiply" -> {
                    System.out.print("Enter a value: ");
                    value = Float.parseFloat(input.nextLine());
                    calc.multiply(value);
                }
                case "divide" -> {
                    System.out.print("Enter a value: ");
                    value = Float.parseFloat(input.nextLine());
                    calc.divide(value);
                }
                case "reset" -> calc.reset();
                case "exit" -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice.");
            }

            System.out.println("The result is = " + calc.getResult());
        } while(!choice.equals("exit"));
    }
}
