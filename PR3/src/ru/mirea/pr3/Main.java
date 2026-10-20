package ru.mirea.pr3;

public class Main {
    public static void main(String[] args) {
        Swimmer swimmer = new Swimmer();
        swimmer.run();
        swimmer.neigh();

        Shape s1 = new Circle(5.5, "RED", false);
        System.out.println(s1);
        System.out.println(s1.getArea());
        System.out.println(s1.getPerimeter());

        Circle c1 = (Circle) s1;
        System.out.println(c1.getRadius());

        Shape s2 = new Rectangle(2, 3);
        System.out.println(s2.getArea());

        Shape s3 = new Square(6);
        System.out.println(s3.getArea());

        MovablePoint point = new MovablePoint(5, 10, 2, 3);
        System.out.println(point);
        point.moveUp();
        System.out.println(point);

        MovableCircle circle = new MovableCircle(5, 5, 2, 2, 10);
        circle.moveRight();
        System.out.println(circle);

        MovableRectangle rectangle = new MovableRectangle(0, 0, 10, 5, 2, 2);
        System.out.println(rectangle.hasSameSpeed());
        rectangle.moveDown();
        System.out.println(rectangle);
    }
}
