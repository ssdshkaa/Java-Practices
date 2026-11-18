package ru.mirea.pr1;
import java.util.Scanner;
public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Задание 4. Сколько чисел в массиве?");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Количество должно быть больше нуля");
            return;
        }
        int[] numbers = new int[n];
        int i = 0;
        while (i < n) {
            System.out.print("Введите число " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
            i++;
        }
        int sum = 0;
        int min = numbers[0];
        int max = numbers[0];
        i = 0;
        do {
            sum += numbers[i];
            if (numbers[i] < min) min = numbers[i];
            if (numbers[i] > max) max = numbers[i];
            i++;
        } while (i < n);
        System.out.println("Сумма: " + sum);
        System.out.println("Минимум: " + min);
        System.out.println("Максимум: " + max);
    }
}
