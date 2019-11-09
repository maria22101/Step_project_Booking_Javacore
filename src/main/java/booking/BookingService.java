package booking;

import java.util.List;
import java.util.stream.Collectors;

public class BookingService {
    private BookingDAO bookingDAO = new BookingDAOImpl();

    void createBooking(String flightId, String passengerName, String passengerSurname) {
        bookingDAO.createBooking(flightId, passengerName, passengerSurname);
    }

    public List<Booking> getAllBookings() {
        return bookingDAO.getAll();
    }

    public void updateBooking(Booking updatedBooking) {
        bookingDAO.updateBooking(updatedBooking);
    }

    public boolean deleteBooking(int bookingId) {
        return bookingDAO.deleteBooking(bookingId);
    }

    List<Booking> getUserBookings(String passengerName, String passengerSurname) {
        return bookingDAO.getAll()
                .stream()
                .filter(b -> b.getPassengerName().equals(passengerName) && b.getPassengerSurname().equals(passengerSurname))
                .collect(Collectors.toList());
    }

    public void displayUserBookings(String passengerName, String passengerSurname) {
        getUserBookings(passengerName, passengerSurname)
                .stream()
                .forEach(System.out::println);
    }
}
