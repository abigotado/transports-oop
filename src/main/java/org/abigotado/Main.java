package org.abigotado;

import org.abigotado.app.enums.FuelType;
import org.abigotado.app.interfaces.ElectricPowered;
import org.abigotado.app.interfaces.FuelPowered;
import org.abigotado.app.transport.*;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Transport Management System!");

        while (true) {
            Vehicle vehicle = selectVehicle();
            if (vehicle != null) {
                vehicle.displayInfo();
                vehicle.move();

                // Проверка типа двигателя и вызов метода заправки или зарядки
                if (vehicle instanceof FuelPowered fuelPoweredVehicle) {
                    fuelPoweredVehicle.refuel();
                }
                else if (vehicle instanceof ElectricPowered electricPoweredVehicle) {
                    electricPoweredVehicle.charge();
                }
            }

            System.out.println("Do you want to choose another vehicle? (y/n)");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (!choice.equalsIgnoreCase("y")) {
                System.out.println("Goodbye!");
                break;
            }
        }
        scanner.close();
    }

    private static Vehicle selectVehicle() {
        System.out.println("Choose a vehicle:");
        System.out.println("1. Car");
        System.out.println("2. Airplane");
        System.out.println("3. Trolleybus");
        System.out.println("4. Air Balloon");
        System.out.println("5. Helicopter");
        System.out.println("6. Bus");
        System.out.println("7. Express Train");
        System.out.println("8. Metro");
        System.out.println("9. Tram");

        System.out.println("Enter a number or type 'exit' to exit the program.");

        String input = scanner.nextLine().trim();
        if (input.equalsIgnoreCase("exit")) {
            System.out.println("Goodbye!");
            System.exit(0);
        }

        int choice;
        try {
            choice = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return null;
        }

        return switch (choice) {
            case 1 -> new Car("Car", 120.0, FuelType.GASOLINE);
            case 2 -> new Airplane("Airplane", 900.0);
            case 3 -> new Trolleybus("Trolleybus", 60.0);
            case 4 -> new AirBalloon("Hot Air Balloon", 15.0);
            case 5 -> new Helicopter("Helicopter", 500.0);
            case 6 -> new Bus("Bus", 80.0, FuelType.DIESEL);
            case 7 -> new ExpressTrain("Express Train", 300.0);
            case 8 -> new Metro("Metro", 90.0);
            case 9 -> new Tram("Tram", 40.0);
            default -> {
                System.out.println("Invalid choice. Please enter a number between 1 and 9.");
                yield null;
            }
        };
    }
}