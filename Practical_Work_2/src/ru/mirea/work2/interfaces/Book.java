package ru.mirea.work2.interfaces;
public class Book implements Printable {
    private final String name;
    public Book(String name) { this.name = name; }
    public String getName() { return name; }
    public void print() { System.out.println("Книга: " + name); }
    public static void printBooks(Printable[] items) { for (Printable item : items) if (item instanceof Book) item.print(); }
}
