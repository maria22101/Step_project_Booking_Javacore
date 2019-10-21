package flight;

import java.util.Objects;

public class Flight {
    private String flightId;
    private String destination;
    private long departureTime;
    private int freeSeats;


    public Flight(String flightId, String destination, long departureTime, int freeSeats) {
        this.flightId = flightId;
        this.destination = destination;
        this.departureTime = departureTime;
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

    public long getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(long departureTime) {
        this.departureTime = departureTime;
    }

    public int getFreeSeets() {
        return freeSeats;
    }

    public void setFreeSeets(int freeSeets) {
        this.freeSeats = freeSeets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return departureTime == flight.departureTime &&
                flightId.equals(flight.flightId) &&
                destination.equals(flight.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, destination, departureTime);
    }

    @Override
    public String toString() {
        return flightId + "\t" + destination + "\t" + departureTime + "\t" + freeSeats +"\n"
                + "------------------------\n";
    }// continue with the date-time formatting to "dd-mm-yyyy hour:minutes

    //to try (remove once tested):
    public static void main(String[] args) {
        Flight f1 = new Flight("PS1", "Paris", 00000023233L, 80);
        System.out.println(f1);
    }
}
