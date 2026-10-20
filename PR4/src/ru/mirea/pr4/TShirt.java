package ru.mirea.pr4;
public class TShirt extends Clothes implements MenClothing, WomenClothing {
    public TShirt(Size size, double price, String color) { super(size, price, color); }
    @Override public void dressMan() { System.out.println("Футболка: " + this); }
    @Override public void dressWomen() { System.out.println("Футболка: " + this); }
}
