package booking;

import java.util.Objects;

public class Booking {
    private int bookingId;
    private String flightId;
    private String passengerName;
    private String passengerSurname;
    private int passengersNumber;
    private boolean isBookingValid;

    public Booking(String flightId, String passengerName, String passengerSurname, int passengersNumber) {
        this.flightId = flightId;
        this.passengerName = passengerName;
        this.passengerSurname = passengerSurname;
        this.passengersNumber = passengersNumber;
        isBookingValid = true;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerSurname() {
        return passengerSurname;
    }

    public void setPassengerSurname(String passengerSurname) {
        this.passengerSurname = passengerSurname;
    }

    public boolean isBookingValid() {
        return isBookingValid;
    }

    public void setBookingValid(boolean bookingValid) {
        isBookingValid = bookingValid;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getPassengersNumber() {
        return passengersNumber;
    }

    public void setPassengersNumber(int passengersNumber) {
        this.passengersNumber = passengersNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return bookingId == booking.bookingId &&
                passengersNumber == booking.passengersNumber &&
                isBookingValid == booking.isBookingValid &&
                Objects.equals(flightId, booking.flightId) &&
                Objects.equals(passengerName, booking.passengerName) &&
                Objects.equals(passengerSurname, booking.passengerSurname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, flightId, passengerName, passengerSurname, passengersNumber, isBookingValid);
    }

    @Override
    public String toString() {
        return flightId + "\t" +  passengerName + "\t" + passengerSurname + "\t" + isBookingValid +"\n"
                + "---------------------------------------\n";
    }// continue with the date-time formatting to "dd-mm-yyyy hour:minutes, start with booking ID
}
