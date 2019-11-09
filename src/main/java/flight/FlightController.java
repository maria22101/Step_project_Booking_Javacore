package flight;

import java.util.List;
import java.util.Scanner;

public class FlightController {
    private FlightService flightService = new FlightService();

    public void createNewFlight(String flightId, String destination, String departureTime, int freeSeats) {
        flightService.createNewFlight(flightId, destination, departureTime, freeSeats);
    }

    public void generateFlights(Scanner scanner) {
        flightService.generateFlights(scanner);
    }

    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    public Flight getFlightById(String id) {
        return flightService.getFlightById(id);
    }

    public boolean deleteFlightById(int id) {
        return flightService.deleteFlightById(id);
    }

    public boolean deleteFlight(Flight flight) {
        return flightService.deleteFlight(flight);
    }

    public void displayAllFlights() {
        flightService.displayAllFlights();
    }

    public List<Flight> requestFlights(String destination, String departureDate, int passengersNumber) {
        return flightService.requestFlights(destination, departureDate, passengersNumber);
    }

    public void displayRequestedFlights(String destination, String departureDate, int passengersNumber) {
        flightService.displayRequestedFlights(destination, departureDate, passengersNumber);
    }
}
