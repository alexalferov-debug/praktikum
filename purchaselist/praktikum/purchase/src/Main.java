import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> purchaseList = new ArrayList<>();
        //int productCount = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите одну из команд:");
            System.out.println("1. Добавить товар в список");
            System.out.println("2. Показать список");
            System.out.println("3. Очистить список");
            System.out.println("4. Завершить работу");
            int actionNumber = scanner.nextInt();
            switch (actionNumber) {
                case 1: {
                    System.out.println("Введите наименование товара, который вы хотите добавить в список" +
                            "(вместо пробела используйте символ \"_\")");//Выводим сообщение о необходимости ввести наименование товара
                    String purchase = scanner.next();//считываем с консоли наименование
                    if (purchaseList.contains(purchase)) {
                        System.out.println("Товар " + purchase + " уже присутствует в списке продуктов под номером "+ (purchaseList.indexOf(purchase)+1) +". Добавлен повторно не будет");
                    } else {
                       /* if (productCount >= purchaseList.size()) {//если массив полностью заполнен
                            String[] tempPurchaseList = new String[purchaseList.length + 1];// создаём новый массив, размерность которого на единицу выше текущей
                            for (int i = 0; i < purchaseList.length; i++) {
                                tempPurchaseList[i] = purchaseList[i]; //копируем раннее добавленные товары
                            }
                            purchaseList = tempPurchaseList;//перезаписываем основной массив временным
                        }*/
                        purchaseList.add(purchase);//добавляем товар в список
                        System.out.println("Товар " + purchase + " успешно добавлен в список под номером " + purchaseList.size());
                    }
                    break; //прерываем выполнение
                }
                case 2: {
                    String purchaseWord;
                    String containWord;
                    if (purchaseList.isEmpty()){
                        System.out.println("Список покупок пуст.2");
                        break;
                    } else if (purchaseList.size() == 1) {
                        purchaseWord = "товар:";
                        containWord = "находится";
                    } else if (purchaseList.size() > 1 && purchaseList.size() <= 4) {
                        purchaseWord = "товара:";
                        containWord = "находятся";
                    } else {
                        purchaseWord = "товаров:";
                        containWord = "находится";
                    }
                    System.out.println("В списке покупок " + containWord + " " + purchaseList.size() + " " + purchaseWord);
                    /*for (int i = 0; i < purchaseList.size(); i++) {
                        System.out.println((i + 1) + ". " + purchaseList.get(i));//выводим в цикле наименования всех товаров с индексами
                    }*/
                    int index = 1;
                    for (String purchase : purchaseList){
                        System.out.println(index++ + "."+purchase);
                    }
                    break;
                }
                case 3: {
                    purchaseList.clear();//перезаписываем все элементы массива значениями по умолчанию
                    //productCount = 0;//Сбрасываем счётчик количества покупок
                    System.out.println("Список покупок успешно очищен");
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

}