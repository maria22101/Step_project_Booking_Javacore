package console;

import booking.BookingController;
import flight.Flight;
import flight.FlightController;

import java.io.*;
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
                        "6. Выход (завершение работы приложения)\n"
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

    public static void main(String[] args) {
        printMenu();
        copyFlightsFromFile();
        for (Flight f : flightController.getAllFlights()) {
            System.out.println(f.toString());
        }

//        Scanner scanner = new Scanner(System.in);
//        int userChoice = scanner.nextInt();


//        while (userChoice != 6) {
//            switch (userChoice) {
//                case 1:
//                case 2:
//                case 3:
//                case 4:
//                case 5:
//                case 6:
//                default:
//                    System.out.println("User has not made his decision");
//            }
//        }
    }
}
