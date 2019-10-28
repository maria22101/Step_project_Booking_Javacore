package flight;

import java.util.List;

public interface FlightDAO {
    void createFlight(String flightId, String destination, long departureTime, int freeSeats);
    List<Flight> getAll();
    Flight getFlightById(int id);
    boolean deleteFlight(int flightToDeleteId);
    boolean deleteFlight(Flight flightToDelete);
}
