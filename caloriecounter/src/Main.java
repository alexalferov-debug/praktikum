import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        while (true) {
            printMenu();
            int actionNumber = scanner.nextInt();
            switch (actionNumber) {
                case 1: {
                    stepTracker.addNewNumberStepsPerDay();
                    break; //прерываем выполнение
                }
                case 2: {
                    stepTracker.changeStepGoal();
                    break;
                }
                case 3: {
                    stepTracker.printStatistic();
                    break;
                }
                case 4:
                    System.out.println("Завершаем работу программы, спасибо!");
                    return;//Прерываем выполнение цикла
                default:
                    System.out.println("Команда " + actionNumber + " не реализована, выберете из доступных команд.");
            }
        }
    }

    static void printMenu() {
        System.out.println("Какое действие вы хотите выполнить? ");
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Изменить цель по количеству шагов в день;");
        System.out.println("3. Напечатать статистику за определённый месяц;");
        System.out.println("4. Выйти из приложения.");
    }
}