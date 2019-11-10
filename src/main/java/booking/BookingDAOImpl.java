package booking;

import java.io.FileNotFoundException;
import java.util.*;

public class BookingDAOImpl implements BookingDAO {
    private List<Booking> listBooking = new ArrayList<>();

    @Override
    public void createBooking(String flightId, String passengerName, String passengerSurname) {
        Booking newBooking = new Booking(flightId, passengerName, passengerSurname);
        if (listBooking.isEmpty()) {
            newBooking.setBookingId(1);
        } else {
            int lastBookingIndex = listBooking.size() - 1;
            int newBookingId = listBooking.get(lastBookingIndex).getBookingId() + 1;
            newBooking.setBookingId(newBookingId);
        }
        listBooking.add(newBooking);
    }

    @Override
    public List<Booking> getAll() {
        return listBooking;
    }

    @Override
    public void extractBookingsFromFile(Scanner scanner) {
        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.equals("--------------------------------------------------------------------------------")) {
                continue;
            }
            Scanner innerScanner = new Scanner(line);
            innerScanner.useDelimiter("\t");
            int bookingId = innerScanner.nextInt();
            String name = innerScanner.next();
            String surname = innerScanner.next();
            String flightId = innerScanner.next();
            Booking booking = new Booking(bookingId, flightId, name, surname);

            listBooking.add(booking);
        }
    }

    @Override
    public void updateBooking(Booking updatedBooking) {
        if (listBooking.contains(updatedBooking)) {
            listBooking.set(listBooking.indexOf(updatedBooking), updatedBooking);
            return;
        } else listBooking.add(updatedBooking);
    }

    @Override
    public boolean deleteBooking(int bookingId) {
        for (Booking booking : listBooking) {
            if (booking.getBookingId() == bookingId) {
                listBooking.remove(booking);
                return true;
            }
        }
        return false;
    }
}
