/**
  *
  * @author (32465092 MSM Dhlamini)
  * @version (8 September 2023)
*/

public class Seat {
    private String seatNumber;
    private Passenger passenger;

    public Seat(String seatNumber, Passenger passenger) {
        this.seatNumber = seatNumber;
        this.passenger = passenger;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public boolean isReserved() {
        return passenger != null;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void reserve(Passenger passenger) {
        this.passenger = passenger;
    }

    public void cancelReservation() {
        this.passenger = null;
    }
}
