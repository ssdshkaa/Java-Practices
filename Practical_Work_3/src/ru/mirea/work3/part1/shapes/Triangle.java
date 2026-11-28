package ru.mirea.work3.part1.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shape {
    public Triangle(Color color, int x, int y, int width, int height) {
        super(color, x, y, width, height);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(getColor());
        int[] xs = {getX() + getWidth() / 2, getX(), getX() + getWidth()};
        int[] ys = {getY(), getY() + getHeight(), getY() + getHeight()};
        graphics.fillPolygon(xs, ys, 3);
    }
}
