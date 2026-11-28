package ru.mirea.work3.part2;

public class Task2Static {
    private int count = 3;

    public int getCount() {
        return count;
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Task2Static test = new Task2Static();
        System.out.println("count = " + test.getCount());
        System.out.println("5! = " + factorial(5));
    }
}
