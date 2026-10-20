package ru.mirea.pr1;
public class Task5 {
    public static void main(String[] args) {
        System.out.println("Задание 5. Аргументы командной строки:");
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        if (args.length == 0) {
            System.out.println("Аргументы не переданы");
        }
    }
}
