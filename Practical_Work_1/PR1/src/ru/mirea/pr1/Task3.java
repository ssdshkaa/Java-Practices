package ru.mirea.pr1;
public class Task3 {
    public static void main(String[] args) {
        int[] numbers = {3, 5, 7, 9, 11};
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        double average = (double) sum / numbers.length;
        System.out.println("Задание 3. Сумма: " + sum);
        System.out.println("Среднее: " + average);
    }
}
