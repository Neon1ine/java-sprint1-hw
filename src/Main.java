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

    private static int readInput(String str) {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        while (true) {
            System.out.println(str);
            userInput = scanner.nextInt();
            if (str.contains("месяц") && !(userInput < 1 || userInput > 12)) return userInput;
            else if (str.contains("день") && !(userInput < 1 || userInput > 30)) return userInput;
            else if (str.contains("шагов") && !(userInput < 0)) return userInput;
            System.out.println("Ввод не соответствует заданному формату!");
        }

    }

    public static int readMonth() {
        return readInput("Введите месяц от 1 до 12:");
    }

    public static int readDay() {
        return readInput("Введите день от 1 до 30:");
    }

    public static int readSteps() {
        return readInput("Введите количество шагов:");
    }
}
