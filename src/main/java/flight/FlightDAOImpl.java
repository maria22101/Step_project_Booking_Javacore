package flight;

import java.util.ArrayList;
import java.util.List;

public class FlightDAOImpl implements FlightDAO {
    private List<Flight> listFlight = new ArrayList<>();

    @Override
    public void createFlight(String flightId, String destination, long departureTime, int freeSeats) {
        Flight flight = new Flight(flightId, destination, departureTime, freeSeats);
        listFlight.add(flight);
    }

    @Override
    public List<Flight> getAll() {
        return listFlight;
    }

    @Override
    public Flight getFlightById(int id) {
        if (id < listFlight.size()) {
            return listFlight.get(id);
        } else return null;
    }

    @Override
    public boolean deleteFlight(int flightToDeleteId) {
        if (flightToDeleteId < listFlight.size()) {
            listFlight.remove(flightToDeleteId);
            return true;
        } else return false;
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