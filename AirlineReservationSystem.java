/**
 * @author (32465092 MSM Dhlamini)
 * @version (8 September 2023)
 */

import java.util.*;
import java.util.Scanner;

public class AirlineReservationSystem {
    private MyLinkedList<Passenger> passengers = new MyLinkedList<>();
    private MyLinkedList<Flight> flights = new MyLinkedList<>();

    public AirlineReservationSystem() {
        Flight flight1 = new Flight("FL101");
        Flight flight2 = new Flight("FL102");
        Flight flight3 = new Flight("FL103");
        flights.append(flight1);
        flights.append(flight2);
        flights.append(flight3);
        initializeDummyPassengerData();
    }

    private void initializeDummyPassengerData() {
        Passenger passenger1 = new Passenger("8201031234087", "Male", "Dlamini", "Mthokozisi", "071-234-5678", "FL101", "A1");
        Passenger passenger2 = new Passenger("9305194567123", "Female", "Ngwenya", "Lindiwe", "082-345-6789", "FL102", "B2");
        Passenger passenger3 = new Passenger("8907127890123", "Male", "Khumalo", "Sipho", "083-456-7890", "FL101", "A2");
        Passenger passenger4 = new Passenger("9506076543121", "Female", "Nkosi", "Zanele", "074-123-4567", "FL103", "C3");
        Passenger passenger5 = new Passenger("8909017890123", "Male", "Mthembu", "Thabo", "076-345-6789", "FL102", "D4");

        passengers.append(passenger1);
        passengers.append(passenger2);
        passengers.append(passenger3);
        passengers.append(passenger4);
        passengers.append(passenger5);
    }

    public void displayMenu() {
        System.out.println("Airline Ticket Reservation System Menu:");
        System.out.println("1. Reserve a Ticket");
        System.out.println("2. Cancel a Reservation");
        System.out.println("3. Check Ticket Reservation");
        System.out.println("4. Display Passengers");
        System.out.println("5. Exit");
    }

    public void reserveTicket() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter flight details:");
        System.out.print("Flight Number: ");
        String flightNumber = scanner.nextLine();
        System.out.print("Seat Number: ");
        String seatNumber = scanner.nextLine();

        Flight flight = findFlight(flightNumber);
        if (flight == null || !flight.isSeatAvailable(seatNumber)) {
            System.out.println("The flight or seat is not available.");
            return;
        }

        System.out.println("Enter passenger details:");
        System.out.print("ID Number: ");
        String idNumber = scanner.nextLine();

        Passenger passenger = findPassenger(idNumber);
        if (passenger == null) {
            System.out.println("Passenger not found. Please add the passenger first.");
            return;
        }

        
        flight.reserveSeat(passenger, seatNumber);

        System.out.println("Ticket reserved successfully!");
    }

    public void cancelTicket() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter flight details for cancellation:");
        System.out.print("Flight Number: ");
        String flightNumber = scanner.nextLine();
        System.out.print("Seat Number: ");
        String seatNumber = scanner.nextLine();

        Flight flight = findFlight(flightNumber);
        if (flight == null || !flight.cancelReservation(seatNumber)) {
            System.out.println("The ticket does not exist for the specified flight and seat.");
        } else {
            System.out.println("Ticket canceled successfully.");
        }
    }

    public void checkTicket() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter ID Number for ticket check:");
        System.out.print("ID Number: ");
        String idNumber = scanner.nextLine();

        Passenger passenger = findPassenger(idNumber);
        if (passenger != null) {
            System.out.println("Ticket found for passenger: " + passenger.getFirstName() + " " + passenger.getLastName());
        } else {
            System.out.println("No ticket found for the specified ID Number.");
        }
    }

    public void displayPassengers() {
        for (Flight flight : flights) {
            System.out.println("Passengers on Flight " + flight.getFlightNumber() + ":");
            LinkedList<Passenger> flightPassengers = flight.getPassengers();
            for (Passenger passenger : flightPassengers) {
                System.out.println(passenger.toString());
            }
        }
    }

    private Flight findFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    private Passenger findPassenger(String idNumber) {
        for (Passenger passenger : passengers) {
            if (passenger.getIDNumber().equals(idNumber)) {
                return passenger;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        AirlineReservationSystem reservationSystem = new AirlineReservationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            reservationSystem.displayMenu();
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    reservationSystem.reserveTicket();
                    break;
                case 2:
                    reservationSystem.cancelTicket();
                    break;
                case 3:
                    reservationSystem.checkTicket();
                    break;
                case 4:
                    reservationSystem.displayPassengers();
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
