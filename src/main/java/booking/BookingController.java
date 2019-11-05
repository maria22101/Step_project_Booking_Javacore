package booking;

import java.util.List;
import java.util.stream.Collectors;

public class BookingController {
    private BookingService bookingService = new BookingService();

    void createBooking(String flightId, String passengerName, String passengerSurname, int passengersNumber) {
        bookingService.createBooking(flightId, passengerName, passengerSurname, passengersNumber);
    }

    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
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
}
