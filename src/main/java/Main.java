import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int visitorCount = getVisitorCount();
        calculateGoods(visitorCount);
    }

    private static int getVisitorCount() {
        int visitorCount;
        while (true) {
            System.out.println("На какое количество людей разделить чек?");
            Scanner scanner = new Scanner(System.in);
            String visitorCountString = scanner.next();
            visitorCount = parseStringIntoInt(visitorCountString);
            if (visitorCount == 1) {
                System.out.println("Нет смысла использовать программу для 1-го человека");
            } else if (visitorCount < 1) {
                System.out.println("Вы ввели некорректное значение");
            } else {
                break;
            }
        }
        return visitorCount;
    }

    private static void calculateGoods(int visitorCount) {
        Calculator calculator = new Calculator();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Пожалуйста, введите название товара или команду 'завершить' чтобы закончить расчет");
            String goodName = scanner.nextLine();
            if (goodName.equalsIgnoreCase("завершить")) {
                break;
            }
            System.out.println("Пожалуйста введите цену товара");
            double goodPrice;
            String goodPriceString = scanner.next();

            goodPrice = parseStringIntoDouble(goodPriceString);

            if (goodPrice < 0) {
                System.out.println("Вы ввели некорректное значение");
            } else {
                Good good = new Good(goodName, goodPrice);
                calculator.addGood(good, 1);
                System.out.println("Товар был успешно добавлен");
            }
        }

        calculator.showOrder();
        double sumToPayPerPerson = calculator.getOrderSum() / visitorCount;
        System.out.println("Каждый должен заплатить: " + String.format("%.2f", sumToPayPerPerson) + " " + calculator.getRubleInRightFormat(sumToPayPerPerson));
    }


    private static int parseStringIntoInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static double parseStringIntoDouble(String string) {
        try {
            return Double.parseDouble(string);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}