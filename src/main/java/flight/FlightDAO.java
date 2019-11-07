package flight;

import java.util.List;
import java.util.Scanner;

public interface FlightDAO {
    void createFlight(String flightId, String destination, long departureTime, int freeSeats);
    List<Flight> getAll();
    void generateFlights(Scanner scanner);
    Flight getFlightById(int id);
    boolean deleteFlight(int flightToDeleteId);
    boolean deleteFlight(Flight flightToDelete);
}
