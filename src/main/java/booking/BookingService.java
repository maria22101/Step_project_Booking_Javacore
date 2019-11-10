package booking;

import flight.FlightController;
import flight.FlightService;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookingService {
    private BookingDAO bookingDAO = new BookingDAOImpl();

    void createBooking(String flightId, String passengerName, String passengerSurname) {
        bookingDAO.createBooking(flightId, passengerName, passengerSurname);
    }

    public List<Booking> getAllBookings() {
        return bookingDAO.getAll();
    }

    public void extractBookingsFromFile(Scanner scanner) {
        bookingDAO.extractBookingsFromFile(scanner);
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

    public void displayUserBookings(String passengerName, String passengerSurname, FlightController flightController) {
        getUserBookings(passengerName, passengerSurname)
                .stream()
                .forEach(booking -> {
                    System.out.print(booking.toString());
                    System.out.print(flightController.getFlightById(booking.getFlightId()).toShortString() + "\t");
                    System.out.println(booking.isBookingValid() ? "booking status: VALID" : "booking status: CANCELLED");
                    System.out.println("--------------------------------------------------------------------------------");
                });
    }

    void loadBookingsToFile(String passengerName, String passengerSurname, FlightController flightController) {
        Path path = Paths.get("C:/Users/HP/IdeaProjects/Step_project_Booking_Javacore/src/main/java/booking/user_bookings.txt");
        try {
            Files.write(path, "".getBytes());
        } catch (IOException e) {
            System.out.println("Создание и подготовка файла к записи не удалась");
        }

        getAllBookings()
                .stream()
                .forEach(booking -> {
                    try {
                        Files.write(path, booking.toString()
                                .getBytes(), StandardOpenOption.APPEND);
                        Files.write(path, (flightController.getFlightById(booking.getFlightId()).toShortString() + "\t")
                                .getBytes(), StandardOpenOption.APPEND);
                        Files.write(path, (booking.isBookingValid() ? "booking status: VALID" : "booking status: CANCELLED")
                                .getBytes(), StandardOpenOption.APPEND);
                        Files.write(path, ("\n" + "--------------------------------------------------------------------------------" + "\n")
                                .getBytes(), StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        System.out.println("Запись не удалась");
                    }
                });
    }
}
