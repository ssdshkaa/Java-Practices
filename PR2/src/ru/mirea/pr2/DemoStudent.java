package ru.mirea.pr2;

public class DemoStudent {
    public static void main(String[] args) {
        Student paul = new Student("Paul Lee", 3.5);
        Student peter = new Student("Peter Tan", 3.9);
        System.out.println(paul.getName());
        paul.printGrade();
        System.out.println(peter.getName());
        peter.printGrade();
    }
}
