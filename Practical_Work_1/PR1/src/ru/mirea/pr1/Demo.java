package ru.mirea.pr1;

public class Demo {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }
        System.out.println("Сумма: " + sum);
        if (sum > 10) {
            System.out.println("Сумма больше 10");
        } else {
            System.out.println("Сумма не больше 10");
        }
    }
}
