package ru.mirea.work2.interfaces;
class PricedBook implements Priceable {
    private final double price;
    PricedBook(double price) { this.price = price; }
    public double getPrice() { return price; }
}
class Phone implements Priceable {
    private final double price;
    Phone(double price) { this.price = price; }
    public double getPrice() { return price; }
}
public class PriceableDemo {
    public static void main(String[] args) {
        Priceable[] items = {new PricedBook(500), new Phone(15000)};
        for (Priceable item : items) System.out.println("Цена: " + item.getPrice());
    }
}
