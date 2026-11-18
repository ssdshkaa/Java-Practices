package ru.mirea.work2.interfaces;
public class Planet implements Nameable {
    private final String name;
    public Planet(String name) { this.name = name; }
    public String getName() { return name; }
}
