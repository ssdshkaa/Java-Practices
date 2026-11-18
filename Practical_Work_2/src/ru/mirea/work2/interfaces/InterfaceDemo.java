package ru.mirea.work2.interfaces;
public class InterfaceDemo {
    public static void main(String[] args) {
        System.out.println(new Planet("Земля").getName());
        System.out.println(new Animal("Кот").getName());
        Printable[] items = {new Book("Java"), new Magazine("Наука"), new Shop("Книги")};
        for (Printable item : items) item.print();
        Book.printBooks(items); Magazine.printMagazines(items);
        Convertable toKelvin = new CelsiusToKelvinConverter();
        Convertable toFahrenheit = new CelsiusToFahrenheitConverter();
        System.out.println(toKelvin.convert(0) + " K, " + toFahrenheit.convert(0) + " F");
    }
}
