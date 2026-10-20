package ru.mirea.pr1;
public class Task7 {
    public static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Задание 7. Факториал " + n + " = " + factorial(n));
    }
}
