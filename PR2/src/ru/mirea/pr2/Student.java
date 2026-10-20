package ru.mirea.pr2;

public class Student {
    String name;
    double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void printGrade() {
        System.out.println(grade);
    }
}
