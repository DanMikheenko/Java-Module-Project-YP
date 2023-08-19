import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int visitorCount = getVisitorCount();
        Calculator calculator = calculateGoods(visitorCount);
    }
    //:todo Поменять язык вывода сообщений на русский
    private static int getVisitorCount(){
        int visitorCount;
        while (true){
            System.out.println("How many people have to pay the check?");
            Scanner scanner = new Scanner(System.in);
            visitorCount = scanner.nextInt();
            if (visitorCount == 1){
                System.out.println("It makes no sense to use the program for 1 person");
            } else if (visitorCount < 1) {
                System.out.println("You typed incorrect value!");
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
            System.out.println("Please, type the name of a good or type 'complete' to finish the calculating");
            String goodName = scanner.nextLine();
            if (goodName.equalsIgnoreCase("complete") ){
                break;
            }
            System.out.println("Please, type the price of the good");
            double goodPrice = scanner.nextDouble();
            Good good = new Good(goodName, goodPrice);
            calculator.addGood(good, 1);
            System.out.println("The good has been successfully added to the calculator");
        }
        calculator.showOrder();
        double sumToPayPerPerson = calculator.getOrderSum()/visitorCount;
        System.out.println("Everyone has to pay: " + String.format("%.2f", sumToPayPerPerson));//:todo Добавить спряжение в зависимости от суммы
        return calculator;
    }
}