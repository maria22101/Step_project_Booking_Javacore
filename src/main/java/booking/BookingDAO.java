package booking;

import java.util.List;

public interface BookingDAO {
    void createBooking(String flightId, String passengerName, String passengerSurname);
    List<Booking> getAll();
    Booking getBooking(String passengerName, String passengerSurname);
    void updateBooking(Booking updatedBooking);
    boolean deleteBooking(String flightId, String passengerName, String passengerSurname);
}
