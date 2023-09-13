/**
  *
  * @author (32465092 MSM Dhlamini)
  * @version (8 September 2023)
*/

import java.util.LinkedList;

public class Flight {
    private String flightNumber;
    private LinkedList<Passenger> passengers = new LinkedList<>();
    private String[] seats = new String[10];

    public LinkedList<Passenger> getPassengers() {
        return passengers;
    }

    public Flight(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public boolean isSeatAvailable(String seatNumber) {
        if (seatNumber.length() == 2) {
            char seatLetter = seatNumber.charAt(0);
            int seatNumberInt = Character.getNumericValue(seatNumber.charAt(1));

            if (seatLetter >= 'A' && seatLetter <= 'J' && seatNumberInt >= 1 && seatNumberInt <= seats.length) {
                int seatIndex = seatLetter - 'A';
                return seats[seatIndex * seats.length + seatNumberInt - 1] == null;
            }
        }
        return false;
    }

    public boolean reserveSeat(Passenger passenger, String seatNumber) {
        if (seatNumber.length() == 2) {
            char seatLetter = seatNumber.charAt(0);
            int seatNumberInt = Character.getNumericValue(seatNumber.charAt(1));

            if (seatLetter >= 'A' && seatLetter <= 'J' && seatNumberInt >= 1 && seatNumberInt <= seats.length) {
                int seatIndex = seatLetter - 'A';
                int arrayIndex = seatIndex * seats.length + seatNumberInt - 1;
                if (seats[arrayIndex] == null) {
                    seats[arrayIndex] = passenger.getIDNumber();
                    passengers.add(passenger);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean cancelReservation(String seatNumber) {
        if (seatNumber.length() == 2) {
            char seatLetter = seatNumber.charAt(0);
            int seatNumberInt = Character.getNumericValue(seatNumber.charAt(1));

            if (seatLetter >= 'A' && seatLetter <= 'J' && seatNumberInt >= 1 && seatNumberInt <= seats.length) {
                int seatIndex = seatLetter - 'A';
                int arrayIndex = seatIndex * seats.length + seatNumberInt - 1;
                if (seats[arrayIndex] != null) {
                    String passengerID = seats[arrayIndex];
                    seats[arrayIndex] = null;
                    passengers.removeIf(passenger -> passenger.getIDNumber().equals(passengerID));
                    return true;
                }
            }
        }
        return false;
    }

    public void displayPassengers() {
        for (Passenger passenger : passengers) {
            System.out.println(passenger.toString());
        }
    }
}
