package ru.mirea.work2.dates;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class TaskDates {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Разработчик: Соломатников");
        System.out.print("Дата получения (dd.MM.yyyy HH:mm): "); String received = in.nextLine();
        System.out.print("Дата сдачи (dd.MM.yyyy HH:mm): "); String submitted = in.nextLine();
        System.out.println("Сейчас: " + new Date());
        System.out.println("Получено: " + received + ", сдано: " + submitted);
    }
}
