package ru.mirea.work3.part2;

import ru.mirea.pr3.Circle;

public class Task5CircleArray {
    public static Circle findLargest(Circle[] circles) {
        if (circles.length == 0) {
            throw new IllegalArgumentException("Массив кругов пуст");
        }
        Circle largest = circles[0];
        for (int i = 1; i < circles.length; i++) {
            if (circles[i].getArea() > largest.getArea()) {
                largest = circles[i];
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        Circle[] circles = {new Circle(2), new Circle(5), new Circle(1), new Circle(3)};
        for (int i = 0; i < circles.length; i++) {
            System.out.println("Радиус: " + circles[i].getRadius() + ", площадь: " + circles[i].getArea());
        }
        Circle largest = findLargest(circles);
        System.out.println("Максимум: радиус " + largest.getRadius() + ", площадь " + largest.getArea());
    }
}
