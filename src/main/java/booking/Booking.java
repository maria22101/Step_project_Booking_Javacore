package booking;

import java.util.Objects;

public class Booking {
    private String flightId;
    private String destination;
    private long departureTime;
    private String passengerName;
    private String passengerSurname;
    private boolean isBookingValid = true;

    public Booking(String flightId, String passengerName, String passengerSurname) {
        this.flightId = flightId;
        this.passengerName = passengerName;
        this.passengerSurname = passengerSurname;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public long getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(long departureTime) {
        this.departureTime = departureTime;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return isBookingValid == booking.isBookingValid &&
                flightId.equals(booking.flightId) &&
                passengerName.equals(booking.passengerName) &&
                passengerSurname.equals(booking.passengerSurname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, passengerName, passengerSurname);
    }

    @Override
    public String toString() {
        return flightId + "\t" + destination + "\t" + departureTime + "\t" +
                passengerName + "\t" + passengerSurname + "\t" + isBookingValid +"\n"
                + "---------------------------------------\n";
    }// continue with the date-time formatting to "dd-mm-yyyy hour:minutes
}
