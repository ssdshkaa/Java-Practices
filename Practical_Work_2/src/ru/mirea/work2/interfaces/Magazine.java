package ru.mirea.work2.interfaces;
public class Magazine implements Printable {
    private final String name;
    public Magazine(String name) { this.name = name; }
    public String getName() { return name; }
    public void print() { System.out.println("Журнал: " + name); }
    public static void printMagazines(Printable[] items) { for (Printable item : items) if (item instanceof Magazine) item.print(); }
}
