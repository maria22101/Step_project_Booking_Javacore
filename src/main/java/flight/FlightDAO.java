package flight;

import java.util.List;
import java.util.Scanner;

public interface FlightDAO {
    void createFlight(String flightId, String destination, String departureTime, int freeSeats);
    List<Flight> getAll();
    void generateFlights(Scanner scanner);
    Flight getFlightById(String id);
    boolean deleteFlight(String flightToDeleteId);
    boolean deleteFlight(Flight flightToDelete);
}
