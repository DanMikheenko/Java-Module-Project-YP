import java.util.HashMap;

public class Calculator {
    private double orderSum;
    private final HashMap<Good, Integer> order = new HashMap<>();

    public void addGood(Good good, int quantity) {
        if (order.containsKey(good)) {
            int oldQuantity = order.get(good);
            int newQuantity = oldQuantity + quantity;
            order.put(good, newQuantity);
        } else {
            order.put(good, quantity);
        }
        orderSum = calculate();

    }

    private double calculate() {
        double sum = 0;

        for (Good good : order.keySet()) {
            int quantity = order.get(good);
            sum += good.price * quantity;
        }

        return sum;
    }

    public void showOrder() {
        System.out.println("Добавленные товары:");
        for (Good good : order.keySet()) {
            System.out.println(good.name + " " + String.format("%.2f", good.price));
        }
    }

    public double getOrderSum() {
        return orderSum;
    }

    public String getRubleInRightFormat(double rubles) {

        int lastDigit = (int) (Math.floor(rubles) % 10);
        if (((int) (Math.floor(rubles) % 100))<=19 && ((int) (Math.floor(rubles) % 100))>=11)
            return "рублей";
        switch (lastDigit) {
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }

    }
}
