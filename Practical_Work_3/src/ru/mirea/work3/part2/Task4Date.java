package ru.mirea.work3.part2;

import java.util.Date;

public class Task4Date {
    public static void main(String[] args) {
        Date[] dates = new Date[10];

        System.out.println(dates[0]); // Пока null.
        dates[0] = new Date();        // Создали объект даты.
        System.out.println(dates[0].toString());
    }
}
