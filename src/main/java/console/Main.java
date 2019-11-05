package console;

public class Main {
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

    public static void main(String[] args) {
        printMenu();

    }
}
