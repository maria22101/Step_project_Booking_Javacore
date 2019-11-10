package booking;

import java.util.List;
import java.util.Scanner;

public interface BookingDAO {
    void createBooking(String flightId, String passengerName, String passengerSurname);
    List<Booking> getAll();
    void extractBookingsFromFile(Scanner scanner);
    void updateBooking(Booking updatedBooking);
    boolean deleteBooking(int BookingId);
}
