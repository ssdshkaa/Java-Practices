package ru.mirea.work3.part2;

import java.util.Random;

public class Task7SelectionSort {
    public static void selectionSort(int[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < values.length; j++) {
                if (values[j] < values[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = values[i];
            values[i] = values[minIndex];
            values[minIndex] = temp;
        }
    }

    public static boolean isSorted(int[] values) {
        for (int i = 1; i < values.length; i++) {
            if (values[i - 1] > values[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int size = 20;
        if (args.length > 0) {
            if (!"--full".equals(args[0]) || args.length != 1) {
                System.err.println("Запуск: Task7SelectionSort [--full]");
                return;
            }
            size = 100000;
        }
        int[] values = new int[size];
        Random random = new Random(42);
        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt();
        }
        StopWatch watch = new StopWatch();
        watch.start();
        selectionSort(values);
        watch.stop();
        System.out.println("Чисел: " + size + ", время: " + watch.getElapsedTime() + " мс");
        System.out.println("Отсортировано: " + isSorted(values));
        if (!isSorted(values)) {
            throw new IllegalStateException("Ошибка сортировки");
        }
    }
}
