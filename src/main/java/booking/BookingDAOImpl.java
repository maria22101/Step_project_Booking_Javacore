package booking;

import java.util.HashSet;
import java.util.Set;

public class BookingDAOImpl implements BookingDAO {
    private Set<Booking> bookings = new HashSet<>();

    @Override
    public void createBooking(String flightId, String passengerName, String passengerSurname) {
        Booking booking = new Booking(flightId, passengerName, passengerSurname);
        bookings.add(booking);
    }

    @Override
    public Set<Booking> getAll() {
        return bookings;
    }

    @Override
    public Booking getBooking(String passengerName, String passengerSurname) {
        for (Booking booking : bookings) {
            if (booking.getPassengerName().equals(passengerName) && booking.getPassengerSurname().equals(passengerSurname)) {
                return booking;
            }
        }
        return null;
    }

    @Override
    public void updateBooking(Booking updatedBooking) {
        bookings.add(updatedBooking);
    }

    @Override
    public boolean deleteBooking(String flightId, String passengerName, String passengerSurname) {
        for (Booking booking : bookings) {
            if (booking.getFlightId().equals(flightId)
                    && booking.getPassengerName().equals(passengerName)
                    && booking.getPassengerSurname().equals(passengerSurname)) {
                bookings.remove(booking);
                return true;
            }
        }
        return false;
    }
}
