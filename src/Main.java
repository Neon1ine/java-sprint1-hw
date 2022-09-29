import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int menuChoice = scanner.nextInt();
            if (menuChoice == 1) {

            } else if (menuChoice == 2) {
                System.out.println("За этот день вы прошли " + StepTracker.findStepsFor1Day() + " шагов.");
            } else if (menuChoice == 3) {

            } else if (menuChoice == 4) {
                System.out.println("Завершение программы.");
                return;
            } else {
                System.out.println("Такой команды не существует!");
            }
        }

    }

    private static void printMenu() {
        System.out.println("Введите число от 1 до 4, соответствующее одной из команд:" +
                "\n 1. Ввести количество шагов за определённый день;" +
                "\n 2. Напечатать статистику за определённый месяц;" +
                "\n 3. Изменить цель по количеству шагов в день;" +
                "\n 4. Выйти из приложения.");
    }

    public static int readMonth() {
        Scanner scanner = new Scanner(System.in);
        int month = 0;
        while (month < 1 || month > 12) {
            System.out.println("Введите месяц от 1 до 12:");
            month = scanner.nextInt();
        }
        return month;
    }

    public static int readDay() {
        Scanner scanner = new Scanner(System.in);
        int day = 0;
        while (day < 1 || day > 30) {
            System.out.println("Введите день от 1 до 30:");
            day = scanner.nextInt();
        }
        return day;
    }

}
