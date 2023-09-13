/**
  *
  * @author (32465092 MSM Dhlamini)
  * @version (8 September 2023)
*/

public class Passenger {
    private String IDNumber;
    private String gender;
    private String lastName;
    private String firstName;
    private String contactNumber;
    private String flightNumber;
    private String seatNumber;

    public Passenger(String IDNumber, String gender, String lastName, String firstName, String contactNumber, String flightNumber, String seatNumber) {
        this.IDNumber = IDNumber;
        this.gender = gender;
        this.lastName = lastName;
        this.firstName = firstName;
        this.contactNumber = contactNumber;
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
    }

    public String getIDNumber() {
        return IDNumber;
    }
    public String getIdNumber() {
        return this.IDNumber;
    }

    public String getGender() {
        return this.gender;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getContactNumber() {
        return this.contactNumber;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public String getSeatNumber() {
        return this.seatNumber;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "IDNumber='" + IDNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                '}';
    }
}
