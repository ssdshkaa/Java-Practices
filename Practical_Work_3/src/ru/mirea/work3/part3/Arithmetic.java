package ru.mirea.work3.part3;

public class Arithmetic {
    public static double calculate(double first, double second, String operation) {
        if (!Double.isFinite(first) || !Double.isFinite(second)) {
            throw new IllegalArgumentException("Введите конечные числа");
        }
        double result;
        switch (operation) {
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                if (second == 0) {
                    throw new IllegalArgumentException("Деление на ноль невозможно");
                }
                result = first / second;
                break;
            default:
                throw new IllegalArgumentException("Неизвестная операция");
        }
        if (!Double.isFinite(result)) {
            throw new IllegalArgumentException("Слишком большое число");
        }
        return result;
    }
}
