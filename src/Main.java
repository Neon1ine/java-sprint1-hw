import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int menuChoice = scanner.nextInt();
            if (menuChoice == 1) {
                StepTracker.changeStepsIn1Day();
            } else if (menuChoice == 2) {
                printStats();
            } else if (menuChoice == 3) {
                System.out.println("Изначальная цель на день - " + StepTracker.stepPerDayAim + " шагов.");
                StepTracker.changeAimSteps();
            } else if (menuChoice == 4) {
                System.out.println("Завершение программы.");
                return;
            } else {
                System.out.println("Такой команды не существует!");
            }
        }

    }

    private static void printStats() {
        int month = Main.readMonth();
        int sum = StepTracker.findSumSteps(month);
        printStepsForMonth(month);
        System.out.println("За этот месяц вы прошли " + sum + " шагов." +
                "\nМаксимальное количество шагов: " + StepTracker.findMaxSteps(month) +
                "\nСреднее количество шагов: " + StepTracker.findAverageSteps(sum) +
                "\nПройденная дистанция (в км): " + StepTracker.findDistance(sum) +
                "\nКоличество сожжённых килокалорий: " + StepTracker.findCalories(sum) +
                "\nЛучшая серия: " + StepTracker.findBestEpisode(month));

    }

    private static void printStepsForMonth(int month) {
        System.out.println("Количество пройденных шагов по дням: ");
        for (int i = 1; i < 31; i++) {
            System.out.print(i + " день: " + StepTracker.findStepsFor1Day(month, i) + ", ");
        }
        System.out.println();
    }

    private static void printMenu() {
        System.out.println("Введите число от 1 до 4, соответствующее одной из команд:" +
                "\n1. Ввести количество шагов за определённый день;" +
                "\n2. Напечатать статистику за определённый месяц;" +
                "\n3. Изменить цель по количеству шагов в день;" +
                "\n4. Выйти из приложения.");
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

    public static int readSteps() {
        Scanner scanner = new Scanner(System.in);
        int steps = -1;
        while (steps < 0) {
            System.out.println("Введите количество шагов:");
            steps = scanner.nextInt();
        }
        return steps;
    }
}
