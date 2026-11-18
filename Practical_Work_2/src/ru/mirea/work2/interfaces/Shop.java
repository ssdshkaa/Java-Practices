package ru.mirea.work2.interfaces;
public class Shop implements Printable {
    private final String name;
    public Shop(String name) { this.name = name; }
    public void print() { System.out.println("Магазин: " + name); }
}
