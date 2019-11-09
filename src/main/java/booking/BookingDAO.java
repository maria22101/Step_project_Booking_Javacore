package booking;

import java.util.List;

public interface BookingDAO {
    void createBooking(String flightId, String passengerName, String passengerSurname);
    List<Booking> getAll();
    void updateBooking(Booking updatedBooking);
    boolean deleteBooking(int BookingId);
}
