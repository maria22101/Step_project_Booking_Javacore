package console;

import booking.Booking;
import booking.BookingController;
import flight.Flight;
import flight.FlightController;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static FlightController flightController = new FlightController();
    static BookingController bookingController = new BookingController();

    static void printMenu() {
        System.out.println(
                "Введите интересующий Вас пункт меню:\n" +
                        "1. Онлайн-табло (рейсы из Киева в ближайшие 24 часа)\n" +
                        "2. Посмотреть информацию о рейсе\n" +
                        "3. Поиск и бронировка рейса\n" +
                        "4. Отменить бронирование\n" +
                        "5. Мои рейсы\n" +
                        "6. Выход (завершение работы приложения)"
        );
    }

    static void copyFlightsFromFile() {
        try {
            Scanner scanner = new Scanner(new FileReader("C:/Users/HP/IdeaProjects/Step_project_Booking_Javacore/src/main/java/flight/flightsDatabase.txt"));
            flightController.generateFlights(scanner);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void copyBookingsFromFile() {
        try {
            Scanner scanner = new Scanner(new FileReader("C:/Users/HP/IdeaProjects/Step_project_Booking_Javacore/src/main/java/booking/user_bookings.txt"));
            bookingController.extractBookingsFromFile(scanner);
        } catch (InputMismatchException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        printMenu();
        copyFlightsFromFile();
        copyBookingsFromFile();

        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();
        String userName = null;
        String userSurname = null;

        while (userChoice != 6) {
            switch (userChoice) {
                case 1:
                    flightController.displayAllFlights();
                    break;

                case 2:
                    System.out.print("Введите ID рейса: ");
                    Scanner scan2 = new Scanner(System.in);
                    String userFlightIdChoice = scan2.nextLine();
                    System.out.println(flightController.getFlightById(userFlightIdChoice));
                    break;

                case 3:
                    System.out.print("Введите место назначения: ");
                    Scanner scan3 = new Scanner(System.in);
                    String userDestinationChoice = scan3.nextLine();

                    System.out.print("Введите дату вылета: ");
                    scan3 = new Scanner(System.in);
                    String userFlightDateChoice = scan3.nextLine();

                    System.out.print("Введите количество пассажиров: ");
                    scan3 = new Scanner(System.in);
                    int userPassengersNumberChoice = scan3.nextInt();

                    flightController.displayRequestedFlights(userDestinationChoice, userFlightDateChoice, userPassengersNumberChoice);

                    System.out.println("Введите номер рейса билеты на который хотите забронировать или 0(ноль) для возврата в главное меню");
                    scan3 = new Scanner(System.in);
                    try {
                        int userBookingChoice = scan3.nextInt();
                        break;
                    } catch (Exception e) {
                    }
                    String userFlightId = scan3.nextLine();
                    for (int i = 0; i < userPassengersNumberChoice; i++) {

                        System.out.printf("Введите имя для пассажира № %d: ", i + 1);
                        scan3 = new Scanner(System.in);
                        userName = scan3.nextLine();

                        System.out.printf("Введите фамилию для пассажира № %d: ", i + 1);
                        scan3 = new Scanner(System.in);
                        userSurname = scan3.nextLine();

                        bookingController.createBooking(userFlightId, userName, userSurname);
                    }
                    break;

                case 4:
                    System.out.print("Введите ID бронирования которое хотите отменить: ");
                    Scanner scan4 = new Scanner(System.in);
                    int userBookingIdToDelete = scan4.nextInt();
                    bookingController.deleteBooking(userBookingIdToDelete);
                    break;

                case 5:
                    System.out.print("Введите Ваше имя: ");
                    Scanner scan5 = new Scanner(System.in);
                    userName = scan5.nextLine();

                    System.out.print("Введите Вашу фамилию: ");
                    userSurname = scan5.nextLine();

                    bookingController.displayUserBookings(userName, userSurname, flightController);
                    break;

                default:
                    System.out.println("User has not made his decision");
            }

            printMenu();
            userChoice = scanner.nextInt();
            if (userChoice == 6) {
                bookingController.loadBookingsToFile(userName, userSurname, flightController);
            }
        }
    }
}
