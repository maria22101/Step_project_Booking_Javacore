package flight;

import java.util.List;
import java.util.stream.Collectors;

public class FlightService {
    private FlightDAO flightDAO = new FlightDAOImpl();

    public void createNewFlight(String flightId, String destination, long departureTime, int freeSeats) {
        flightDAO.createFlight(flightId, destination, departureTime, freeSeats);
    }

    public List<Flight> getAllFlights() {
        return flightDAO.getAll();
    }

    public Flight getFlightById(int id) {
        return flightDAO.getFlightById(id);
    }

    public boolean deleteFlightById(int id) {
        return flightDAO.deleteFlight(id);
    }

    public boolean deleteFlight(Flight flight) {
        return flightDAO.deleteFlight(flight);
    }

    void displayAllFlights() {
        getAllFlights().stream().forEach(System.out::println);
    }

    public List<Flight> findFlights(String destination, long departureTime, int passengersNumber) {
        return getAllFlights()
                .stream()
                .filter(f -> f.getDestination().equals(destination)
                        && f.getDepartureTime() == departureTime
                        && f.getFreeSeets() >= passengersNumber)
                .collect(Collectors.toList());
    }

    public void displayFoundFlights(String destination, long departureTime, int passengersNumber) {
        findFlights(destination, departureTime, passengersNumber)
                .stream()
                .forEach(System.out::print);
    }
}
