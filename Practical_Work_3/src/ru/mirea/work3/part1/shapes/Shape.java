package ru.mirea.work3.part1.shapes;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
    private Color color;
    private int x;
    private int y;
    private int width;
    private int height;

    public Shape(Color color, int x, int y, int width, int height) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public abstract void draw(Graphics graphics);
}
