package flight;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Flight {
    private String flightId;
    private String destination;
    private Date departureTime;
    private int freeSeats;


    public Flight(String flightId, String destination, String departureTime, int freeSeats) {
        this.flightId = flightId;
        this.destination = destination;

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        try{
            this.departureTime = formatter.parse(departureTime);
        }catch (ParseException e) {
            e.printStackTrace();
        }

        this.freeSeats = freeSeats;
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

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(int freeSeats) {
        this.freeSeats = freeSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return flightId.equals(flight.flightId) &&
                destination.equals(flight.destination) &&
                departureTime.equals(flight.departureTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, destination, departureTime);
    }

    @Override
    public String toString() {
        return flightId + "\t" +
                destination + "\t" +
                new SimpleDateFormat("dd.MM.yyyy hh:mm").format(departureTime) + "\t" +
                freeSeats + " seats available" +"\n"
                + "--------------------------------------------------------------";
    }
}
