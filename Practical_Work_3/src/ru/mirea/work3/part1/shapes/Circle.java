package ru.mirea.work3.part1.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {
    public Circle(Color color, int x, int y, int diameter) {
        super(color, x, y, diameter, diameter);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(getColor());
        graphics.fillOval(getX(), getY(), getWidth(), getHeight());
    }
}
