package ru.mirea.work2.patterns;

public class PrintStringListener implements StringListener {
    public void textChanged(String text) {
        System.out.println("Строка изменена: " + text);
    }
}
