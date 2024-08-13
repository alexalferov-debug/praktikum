import data.Months;

import java.util.Objects;
import java.util.Scanner;

class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 0;

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.print("Введите номер месяца: ");
        int monthNumber = scanner.nextInt();
        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Введен некорректный номер месяца, процедура добавления шагов прервана");
            return;
        }
        System.out.print("Введите номер дня: ");
        int dayNumber = scanner.nextInt();
        if (dayNumber < 1 || dayNumber > 30) {
            System.out.println("Введен некорректный номер дня, процедура добавления шагов прервана");
            return;
        }
        System.out.print("Введите количество шагов: ");
        int stepsCount = scanner.nextInt();
        if (stepsCount <= 0) {
            System.out.println("Число шагов должно быть больше 0, процедура добавления шагов прервана");
            return;
        }
        monthToData[monthNumber-1].days[dayNumber-1] += stepsCount;
        System.out.println("Мы успешно сохранили прогресс за день!");
    }

    void changeStepGoal() {
        System.out.println("Давай установим новую цель по числу шагов: ");
        int newStepsGoal = scanner.nextInt();
        if (newStepsGoal <= 0) {
            System.out.println("Эй, дружище! Ты что, серьёзно? " +
                    "Цель по количеству шагов не может быть меньше или равна нулю!" +
                    " Давай-ка проснись и придумай что-нибудь поинтереснее, чем ноль или отрицательное число. " +
                    "Ведь мы тут за большие свершения, а не за стояние на месте!" +
                    " Шевелись, спортсмен, и поставь себе достойную цель!");
        } else {
            System.out.println("Новая ежедневная цель по количеству шагов - " + newStepsGoal);
            goalByStepsPerDay = newStepsGoal;
        }
    }

    void printStatistic() {
        System.out.print("Введите номер месяца: ");
        int monthNumber = scanner.nextInt();
        Months currentMonth = Months.getMonthByNumberOrNull(monthNumber);
        if (Objects.isNull(currentMonth)) {
            System.out.println("Номер месяца введен некорректно, должен быть в диапазоне от одного до двенадцати");
            return;
        } else {
            System.out.println("Статистика за " + currentMonth.getName().toLowerCase() + ":");
        }
        MonthData monthData = monthToData[monthNumber-1];
        System.out.println("Пройдено шагов за каждый из дней: ");
        monthData.printDaysAndStepsFromMonth();
        System.out.print(" Суммарно ты прошёл "
                + monthData.sumStepsFromMonth() + " шагов за " + currentMonth.getName().toLowerCase()
                + ", это целых " + Converter.convertToKm(monthData.sumStepsFromMonth()) + " километров и сжёг " +
                Converter.convertStepsToKilocalories(monthData.sumStepsFromMonth()) + " калорий.");
        System.out.print(" Максимальное число шагов за один день составило "
                + monthData.maxSteps() + ". Так держать!");
        System.out.print(" В среднем проходил ежедневно  "
                + (monthData.sumStepsFromMonth() / monthData.days.length) + " шагов,");
        System.out.println(" при этом максимальное число подряд идущих дней, когда цель по количеству шагов была выполнена: " +
                monthData.bestSeries(goalByStepsPerDay));
    }
} 