package ru.mirea.pr4;
public abstract class Clothes {
    protected Size size;
    protected double price;
    protected String color;
    public Clothes(Size size, double price, String color) {
        this.size = size;
        this.price = price;
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "размер=" + size + " (" + size.getEuroSize() + "), цена=" + price + ", цвет=" + color;
    }
}
