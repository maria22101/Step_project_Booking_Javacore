package booking;

import flight.FlightController;
import flight.FlightService;

import java.util.List;
import java.util.Scanner;

public class BookingController {
    private BookingService bookingService = new BookingService();
    private FlightService flightService = new FlightService();

    public void createBooking(String flightId, String passengerName, String passengerSurname) {
        bookingService.createBooking(flightId, passengerName, passengerSurname);
    }

    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    public void extractBookingsFromFile(Scanner scanner) {
        bookingService.extractBookingsFromFile(scanner);
    }

    public void updateBooking(Booking updatedBooking) {
        bookingService.updateBooking(updatedBooking);
    }

    public boolean deleteBooking(int bookingId) {
        return bookingService.deleteBooking(bookingId);
    }

    List<Booking> getUserBookings(String passengerName, String passengerSurname) {
        return bookingService.getUserBookings(passengerName, passengerSurname);
    }

    public void displayUserBookings(String passengerName, String passengerSurname, FlightController flightController) {
        bookingService.displayUserBookings(passengerName, passengerSurname, flightController);
    }

    public void loadBookingsToFile(String passengerName, String passengerSurname, FlightController flightController) {
        bookingService.loadBookingsToFile(passengerName, passengerSurname, flightController);
    }
}
