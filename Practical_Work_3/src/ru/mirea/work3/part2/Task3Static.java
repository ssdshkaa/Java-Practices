package ru.mirea.work3.part2;

import ru.mirea.pr3.Circle;

public class Task3Static {
    private Circle circle = new Circle();

    public void method1() {
        method2();
    }

    public void method2() {
        System.out.println("Площадь круга: " + circle.getArea());
    }

    public static void main(String[] args) {
        Task3Static object = new Task3Static();
        object.method1();
    }
}
