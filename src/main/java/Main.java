import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int visitorCount = getVisitorCount();
        Calculator calculator = calculateGoods(visitorCount);
    }
    private static int getVisitorCount(){
        int visitorCount;
        while (true){
            System.out.println("На какое количество людей разделить чек?");
            Scanner scanner = new Scanner(System.in);
            visitorCount = scanner.nextInt();
            if (visitorCount == 1){
                System.out.println("Нет смысла использовать программу для 1-го человека");
            } else if (visitorCount < 1) {
                System.out.println("Вы ввели некорректное значение");
            } else {
                break;
            }
        }
        return visitorCount;
    }
    private static Calculator calculateGoods(int visitorCount){
        Calculator calculator = new Calculator();
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Пожалуйста, введите название товара или команду 'завершить' чтобы закончить расчет");
            String goodName = scanner.nextLine();
            if (goodName.equalsIgnoreCase("завершить") ){
                break;
            }
            System.out.println("Пожалуйста введите цену товара");
            double goodPrice = scanner.nextDouble();
            Good good = new Good(goodName, goodPrice);
            calculator.addGood(good, 1);
            System.out.println("Товар был успешно добавлен");
        }
        calculator.showOrder();
        double sumToPayPerPerson = calculator.getOrderSum()/visitorCount;
        System.out.println("Каждый должен заплатить: " + String.format("%.2f", sumToPayPerPerson) + " " + calculator.getRubleInRightFormat(sumToPayPerPerson));
        return calculator;
    }
}