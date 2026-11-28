package ru.mirea.work3.part1.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
    public Rectangle(Color color, int x, int y, int width, int height) {
        super(color, x, y, width, height);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(getColor());
        graphics.fillRect(getX(), getY(), getWidth(), getHeight());
    }
}
