package flight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlightDAOImpl implements FlightDAO {
    private List<Flight> listFlight = new ArrayList<>();

    @Override
    public void createFlight(String flightId, String destination, String departureTime, int freeSeats) {
        Flight flight = new Flight(flightId, destination, departureTime, freeSeats);
        listFlight.add(flight);
    }

    @Override
    public void generateFlights(Scanner scanner) {
        while (scanner.hasNext()) {
            String flightId = scanner.nextLine();
            String destination = scanner.nextLine();
            String departureTime = scanner.nextLine();
            int freeSeats = Integer.parseInt(scanner.nextLine());
            Flight flight = new Flight(flightId, destination, departureTime, freeSeats);

            listFlight.add(flight);
        }
    }

    @Override
    public List<Flight> getAll() {
        return listFlight;
    }

    @Override
    public Flight getFlightById(String id) {
        for (Flight flight : listFlight) {
            if (flight.getFlightId().equals(id)) {
                return flight;
            }
        }
        return null;
    }

    @Override
    public boolean deleteFlight(String flightToDeleteId) {
        for (Flight flight : listFlight) {
            if (flight.getFlightId().equals(flightToDeleteId)) {
                listFlight.remove(flightToDeleteId);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteFlight(Flight flightToDelete) {
        for (Flight flight : listFlight) {
            if (flight.equals(flightToDelete)) {
                listFlight.remove(flight);
                return true;
            }
        }
        return false;
    }
}
