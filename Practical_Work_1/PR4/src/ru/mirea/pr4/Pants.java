package ru.mirea.pr4;
public class Pants extends Clothes implements MenClothing, WomenClothing {
    public Pants(Size size, double price, String color) { super(size, price, color); }
    @Override public void dressMan() { System.out.println("Штаны: " + this); }
    @Override public void dressWomen() { System.out.println("Штаны: " + this); }
}
