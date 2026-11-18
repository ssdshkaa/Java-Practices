package ru.mirea.work2.interfaces;
public class Animal implements Nameable {
    private final String name;
    public Animal(String name) { this.name = name; }
    public String getName() { return name; }
}
