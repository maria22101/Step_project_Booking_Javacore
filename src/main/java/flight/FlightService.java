package flight;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlightService {
    private FlightDAO flightDAO = new FlightDAOImpl();

    public void createNewFlight(String flightId, String destination, String departureTime, int freeSeats) {
        flightDAO.createFlight(flightId, destination, departureTime, freeSeats);
    }

    public void generateFlights(Scanner scanner) {
        flightDAO.generateFlights(scanner);
    }

    public List<Flight> getAllFlights() {
        return flightDAO.getAll();
    }

    public Flight getFlightById(String id) {
        return flightDAO.getFlightById(id);
    }

    public boolean deleteFlightById(String id) {
        return flightDAO.deleteFlight(id);
    }

    public boolean deleteFlight(Flight flight) {
        return flightDAO.deleteFlight(flight);
    }

    void displayAllFlights() {
        getAllFlights().stream().forEach(System.out::println);
    }

    public List<Flight> requestFlights(String destination, String departureDate, int passengersNumber) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        return getAllFlights()
                .stream()
                .filter(f -> f.getDestination().equals(destination)
                        && formatter.format(f.getDepartureTime()).substring(0, 10).equals(departureDate)
                        && f.getFreeSeats() >= passengersNumber)
                .collect(Collectors.toList());
    }

    public void displayRequestedFlights(String destination, String departureDate, int passengersNumber) {
        requestFlights(destination, departureDate, passengersNumber)
                .stream()
                .forEach(System.out::println);
    }
}
